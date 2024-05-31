package com.rinha.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "transacoes")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Long cliente;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "realizado_em")
    private String realizadaEm;
}
