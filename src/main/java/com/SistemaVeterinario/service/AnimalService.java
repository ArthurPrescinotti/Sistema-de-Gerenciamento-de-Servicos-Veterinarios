package com.SistemaVeterinario.service;

import com.SistemaVeterinario.model.Animal;
import com.SistemaVeterinario.model.Usuario;
import com.SistemaVeterinario.repository.AnimalRepository;
import com.SistemaVeterinario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal save(Animal animal){
        animalRepository.save(animal);
        return animal;
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(String id){
        return animalRepository.findById(id);
    }

    public void deleteById(String id){
        animalRepository.deleteById(id);
    }
}
