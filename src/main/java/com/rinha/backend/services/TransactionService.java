package com.rinha.backend.services;

import com.rinha.backend.models.Clients;
import com.rinha.backend.repository.ClientRepository;
import com.rinha.backend.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import com.rinha.backend.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void registerNewTransactionForClient(Long clientId, BigDecimal value, String type, String description) {
        Optional<Clients> optionalCliente = clientRepository.findById(clientId);
        if (!optionalCliente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        Clients cliente = optionalCliente.get();
        if (cliente.getSaldo().compareTo(value) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        if (!type.equals(String.valueOf('d')) || !type.equals(String.valueOf('c'))) {
            throw new RuntimeException("Forneça um tipo válido para a operação");
        }
        cliente.setSaldo(cliente.getSaldo().subtract(value));
        Transaction novaTransacao = new Transaction();
        novaTransacao.setCliente(clientId);
        novaTransacao.setValor(value);
        novaTransacao.setTipo(type);
        novaTransacao.setDescricao(description);
        transactionRepository.save(novaTransacao);
    }
}
