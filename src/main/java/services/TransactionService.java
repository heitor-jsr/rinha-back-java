package services;

import jakarta.transaction.Transactional;
import models.Clients;
import models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import repository.TransactionRepository;

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
        cliente.setSaldo(cliente.getSaldo().subtract(value));
        Transaction novaTransacao = new Transaction();
        novaTransacao.setCliente(cliente);
        novaTransacao.setValor(value);
        novaTransacao.setTipo(type);
        novaTransacao.setDescricao(description);
        transactionRepository.save(novaTransacao);
    }
}
