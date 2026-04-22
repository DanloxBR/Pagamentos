package com.danieldev.pagamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    private String descricao;
    private String idempotencyKey;
    private LocalDateTime criadoEm;
}
