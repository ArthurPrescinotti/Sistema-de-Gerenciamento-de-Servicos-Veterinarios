package com.SistemaVeterinario.controller;

import com.SistemaVeterinario.constant.Constant;
import com.SistemaVeterinario.model.Animal;
import com.SistemaVeterinario.security.JwtTokenProvider;
import com.SistemaVeterinario.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {
    @Autowired
    private JwtTokenProvider jwtTokenValidator;

    @Autowired
    private AnimalService animalService;

    @GetMapping(Constant.API_URL_ANIMAL)
    public ResponseEntity<List<Animal>> findAll (@RequestHeader(value = "Authorization") String token){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(animalService.findAll());
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @PostMapping(Constant.API_URL_ANIMAL)
    public ResponseEntity<Animal> createAnimal (@RequestHeader(value = "Authorization") String token, @RequestBody Animal animal){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @DeleteMapping(Constant.API_URL_ANIMAL + "/{id}")
    public  ResponseEntity<Animal> deleteById (@RequestHeader(value = "Authorization") String token, @PathVariable("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            animalService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

    @GetMapping(Constant.API_URL_ANIMAL + "/{id}")
    public ResponseEntity<Optional<Animal>> findById (@RequestHeader(value = "Authorization") String token, @PathVariable ("id") String id){
        if (jwtTokenValidator.validateToken(token.substring(7))) { // Remove "Bearer " do token
            return ResponseEntity.ok(animalService.findById(id));
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
        }
    }

}
