package com.rinha.backend.repository;

import com.rinha.backend.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}
