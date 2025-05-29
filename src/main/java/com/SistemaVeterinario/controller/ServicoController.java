package com.SistemaVeterinario.controller;

import com.SistemaVeterinario.constant.Constant;
import com.SistemaVeterinario.model.Servico;
import com.SistemaVeterinario.security.JwtTokenProvider;
import com.SistemaVeterinario.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ServicoController {


    @Autowired
    private JwtTokenProvider jwtTokenValidator;

    @Autowired
    private ServicoService servicoService;

    @GetMapping(Constant.API_URL_SERVICO)
    public ResponseEntity<List<Servico>> findAll (@RequestHeader(value = "Authorization") String token){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(servicoService.findAll());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @PostMapping(Constant.API_URL_SERVICO)
    public ResponseEntity<Servico> createServico (@RequestHeader(value = "Authorization") String token, @RequestBody Servico servico){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.save(servico));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @DeleteMapping(Constant.API_URL_SERVICO + "/{id}")
    public  ResponseEntity<Servico> deleteById (@RequestHeader(value = "Authorization") String token, @PathVariable("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            servicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @GetMapping(Constant.API_URL_SERVICO + "/{id}")
    public ResponseEntity<Optional<Servico>> findById (@RequestHeader(value = "Authorization") String token, @PathVariable ("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(servicoService.findById(id));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }
}
