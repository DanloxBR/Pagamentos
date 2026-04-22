package com.danieldev.pagamento.service;

import com.danieldev.pagamento.dto.PagamentoDTO;
import com.danieldev.pagamento.entity.Carteira;
import com.danieldev.pagamento.entity.Pagamento;
import com.danieldev.pagamento.entity.StatusPagamento;
import com.danieldev.pagamento.exception.RegraNegocioException;
import com.danieldev.pagamento.repository.CarteiraRepository;
import com.danieldev.pagamento.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final CarteiraRepository carteiraRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository,
                            CarteiraRepository carteiraRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    public Pagamento criar(PagamentoDTO dto) {

        pagamentoRepository.findByIdempotencyKey(dto.getIdempotencyKey())
                .ifPresent(p -> {
                    throw new RegraNegocioException("Pagamento já processado.");
                });

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(dto.getValor());
        pagamento.setDescricao(dto.getDescricao());
        pagamento.setStatus(StatusPagamento.PENDENTE);
        pagamento.setIdempotencyKey(dto.getIdempotencyKey());
        pagamento.setCriadoEm(LocalDateTime.now());

        return pagamentoRepository.save(pagamento);
    }

    @Transactional
    public Pagamento pagar(Long id) {

        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Pagamento não encontrado!"));

        if (pagamento.getStatus() == StatusPagamento.PAGO) {
            throw new RegraNegocioException("Já pago!");
        }

        Carteira carteira = carteiraRepository.findById(1L)
                .orElseThrow(() -> new RegraNegocioException("Carteira não encontrada!"));

        if (carteira.getSaldo().compareTo(pagamento.getValor()) < 0) {
            throw new RegraNegocioException("Saldo insuficiente!");
        }

        carteira.setSaldo(carteira.getSaldo().subtract(pagamento.getValor()));
        pagamento.setStatus(StatusPagamento.PAGO);
        return pagamentoRepository.save(pagamento);
    }

    @Transactional
    public Pagamento cancelar(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não encontrado!"));
        pagamento.setStatus(StatusPagamento.CANCELADO);
        return pagamentoRepository.save(pagamento);
    }
}