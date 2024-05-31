package com.rinha.backend.controllers;

import com.rinha.backend.models.Extrato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rinha.backend.services.ExtratoService;

@RestController
@RequestMapping("/clientes")
public class ExtratoController {

    private final ExtratoService extratoService;

    public ExtratoController(ExtratoService extratoService) {
        this.extratoService = extratoService;
    }

    @GetMapping("/{clientId}/extrato")
    public ResponseEntity<Extrato> getExtrato(@PathVariable Long clientId) {
        try {
            Extrato extrato = extratoService.getExtrato(clientId);
            return ResponseEntity.ok(extrato);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
