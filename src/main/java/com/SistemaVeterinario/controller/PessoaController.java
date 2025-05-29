package com.SistemaVeterinario.controller;

import com.SistemaVeterinario.constant.Constant;
import com.SistemaVeterinario.model.Pessoa;
import com.SistemaVeterinario.security.JwtTokenProvider;
import com.SistemaVeterinario.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {


    @Autowired
    private JwtTokenProvider jwtTokenValidator;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(Constant.API_URL_PESSOA)
    public ResponseEntity<List<Pessoa>> findAll (@RequestHeader(value = "Authorization") String token){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(pessoaService.findAll());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @PostMapping(Constant.API_URL_PESSOA)
    public ResponseEntity<Pessoa> createPessoa (@RequestHeader(value = "Authorization") String token, @RequestBody Pessoa pessoa ){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @DeleteMapping(Constant.API_URL_PESSOA + "/{id}")
    public  ResponseEntity<Pessoa> deleteById (@RequestHeader(value = "Authorization") String token, @PathVariable("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            pessoaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @GetMapping(Constant.API_URL_PESSOA + "/{id}")
    public ResponseEntity<Optional<Pessoa>> findById (@RequestHeader(value = "Authorization") String token, @PathVariable ("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(pessoaService.findById(id));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }
}
