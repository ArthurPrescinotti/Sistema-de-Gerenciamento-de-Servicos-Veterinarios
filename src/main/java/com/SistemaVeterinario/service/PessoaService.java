package com.SistemaVeterinario.service;

import com.SistemaVeterinario.model.Pessoa;
import com.SistemaVeterinario.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa Pessoa){
        pessoaRepository.save(Pessoa);
        return Pessoa;
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(String id){
        return pessoaRepository.findById(id);
    }

    public void deleteById(String id){
        pessoaRepository.deleteById(id);
    }
}
