package com.SistemaVeterinario.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animal")
@Getter @Setter
public class Animal {

    @Id
    private String id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;

    @ManyToOne
    private Pessoa pessoa;
}
