package com.rinha.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "limite")
    private BigDecimal limite;

    @Column(name = "saldo")
    private BigDecimal saldo;

    public Clients(String nome, BigDecimal limite, BigDecimal saldo) {
        this.nome = nome;
        this.limite = limite;
        this.saldo = saldo;
    }
}
