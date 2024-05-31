package com.rinha.backend.repository;


import com.rinha.backend.models.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {
}
