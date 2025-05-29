package com.SistemaVeterinario.service;

import com.SistemaVeterinario.model.Animal;
import com.SistemaVeterinario.model.Servico;
import com.SistemaVeterinario.repository.AnimalRepository;
import com.SistemaVeterinario.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public Servico save(Servico servico){
        Optional< Animal> animalExiste = animalRepository.findById(servico.getAnimal().getId());
        servico.setAnimal(animalExiste.get());
        servicoRepository.save(servico);
        return servico;
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
