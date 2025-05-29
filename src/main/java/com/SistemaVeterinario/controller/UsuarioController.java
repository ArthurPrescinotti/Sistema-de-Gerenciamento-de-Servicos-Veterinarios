package com.SistemaVeterinario.controller;

import com.SistemaVeterinario.constant.Constant;
import com.SistemaVeterinario.model.Usuario;
import com.SistemaVeterinario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(Constant.API_URL_CADASTRO)
    public ResponseEntity<Usuario> createUsuario (@RequestBody Usuario usuario){
        Usuario savedUsuario = usuarioService.save(usuario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PutMapping(Constant.API_URL_CADASTRO)
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    @DeleteMapping(Constant.API_URL_CADASTRO + "/{id}")
    public ResponseEntity<Usuario> deleteById (@PathVariable("id") String id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(Constant.API_URL_CADASTRO)
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping(Constant.API_URL_CADASTRO + "/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }
}
