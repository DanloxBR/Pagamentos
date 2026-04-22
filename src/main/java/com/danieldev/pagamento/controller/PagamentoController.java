package com.danieldev.pagamento.controller;

import com.danieldev.pagamento.dto.PagamentoDTO;
import com.danieldev.pagamento.entity.Pagamento;
import com.danieldev.pagamento.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    private final PagamentoService service;
    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody PagamentoDTO dto) {
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<Pagamento> pagar(@PathVariable Long id) {
        return ResponseEntity.ok(service.pagar(id));
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Pagamento> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(service.cancelar(id));
    }
}
