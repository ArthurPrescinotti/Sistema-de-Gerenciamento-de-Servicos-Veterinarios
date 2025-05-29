package com.SistemaVeterinario.service;

import com.SistemaVeterinario.model.Servico;
import com.SistemaVeterinario.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico save(Servico Servico){
        servicoRepository.save(Servico);
        return Servico;
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Optional<Servico> findById(String id){
        return servicoRepository.findById(id);
    }

    public void deleteById(String id){
        servicoRepository.deleteById(id);
    }
}
