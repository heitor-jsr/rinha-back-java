package services;

import jakarta.transaction.Transactional;
import models.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.math.BigDecimal;

@Service
public class ClientsService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void registerNewClient(String nome, BigDecimal limite, BigDecimal saldo) {
        Clients newClient = new Clients(nome, limite, saldo);
        clientRepository.save(newClient);
    }
}
