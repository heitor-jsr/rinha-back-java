package services;

import jakarta.transaction.Transactional;
import models.Clients;
import models.Extrato;
import models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExtratoRepository;
import repository.ClientRepository;
import repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtratoService {
    @Autowired
    private TransactionRepository transactionRepository;
    private ExtratoRepository extratoRepository;
    private ClientRepository clientRepository;

    @Transactional
    public Extrato getExtrato(Long clientId) {
        Optional<Clients> optionalCliente = clientRepository.findById(clientId);
        if (!optionalCliente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        Clients cliente = optionalCliente.get();

        ArrayList<Transaction> transactions = transactionRepository.findLatestTenByClientId(clientId)
                .stream()
                .limit(10)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        LocalDateTime agora = LocalDateTime.now();

        BigDecimal total = cliente.getSaldo()
                .add(transactions.stream()
                        .map(Transaction::getValor)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

        if (total.compareTo(cliente.getLimite()) > 0) {
            throw new RuntimeException("A operação deixaria o saldo inconsistente");
        }

        Extrato extrato = new Extrato(cliente.getLimite(), cliente.getSaldo(), agora, transactions);

        return extrato;
    }
}
