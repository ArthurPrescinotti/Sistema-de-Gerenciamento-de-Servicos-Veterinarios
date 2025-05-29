package com.SistemaVeterinario.controller;

import com.SistemaVeterinario.constant.Constant;
import com.SistemaVeterinario.model.ResponseToken;
import com.SistemaVeterinario.model.Usuario;
import com.SistemaVeterinario.repository.UsuarioRepository;
import com.SistemaVeterinario.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CredentialController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(Constant.API_LOGIN)
    public ResponseToken getToken(@RequestBody Usuario usuario){
        Optional<Usuario> UsuarioLogin = usuarioRepository.findByUsuario(usuario.getUsuario());
        if (UsuarioLogin.isPresent() && usuario.getSenha().equals(UsuarioLogin.get().getSenha())) {
            String token = jwtTokenProvider.generateToken(usuario.getUsuario());
            return new ResponseToken("Authenticated", token);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User");
        }
    }
}
