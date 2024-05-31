package com.rinha.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "extrato")
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @JsonProperty("saldo")
    @Column(name = "saldo")
    private BigDecimal saldo;

    @JsonProperty("limite")
    @Column(name = "_limite")
    private BigDecimal limite;

    @JsonProperty("data")
    @Column(name = "data_extrato")
    private LocalDateTime data;

    @JsonProperty("ultimas_transacoes")
    @Column(name = "ultimas_transacoes")
    private ArrayList<Transaction> ultimas_transacoes;

    public Extrato(BigDecimal limite, BigDecimal saldo, LocalDateTime data, ArrayList<Transaction> ultimas_transacoes) {
        this.saldo = saldo;
        this.limite = limite;
        this.data = data;
        this.ultimas_transacoes = ultimas_transacoes;
    }
}
