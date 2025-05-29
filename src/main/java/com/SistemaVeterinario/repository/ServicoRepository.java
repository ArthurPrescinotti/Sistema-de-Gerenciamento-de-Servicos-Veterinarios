package com.SistemaVeterinario.repository;

import com.SistemaVeterinario.model.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends MongoRepository<Servico, String> {
}
