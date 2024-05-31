package com.rinha.backend.repository;

import com.rinha.backend.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.client.id = :clientId ORDER BY t.createdDate DESC")
    List<Transaction> findLatestTenByClientId(@Param("clientId") Long clientId);
}
