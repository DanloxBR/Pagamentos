package com.danieldev.pagamento.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDTO {

    private BigDecimal valor;
    private String descricao;
    private String IdempotencyKey;
}
