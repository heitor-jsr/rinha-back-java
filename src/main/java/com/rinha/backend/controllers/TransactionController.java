package com.rinha.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rinha.backend.services.TransactionService;
import com.rinha.backend.models.Transaction;

@RestController
@RequestMapping("/clientes")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{clientId}/transacao")
    public ResponseEntity<Void> registerNewTransaction(
            @PathVariable Long clientId,
            @RequestBody Transaction transaction) {
        try {
            transactionService.registerNewTransactionForClient(clientId, transaction.getValor(),
                    transaction.getTipo(), transaction.getDescricao());
            return ResponseEntity.accepted().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
