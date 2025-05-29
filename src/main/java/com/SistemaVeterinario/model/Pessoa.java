package com.SistemaVeterinario.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name = "pessoa")
@Getter @Setter
public class Pessoa {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

}
