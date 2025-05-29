package com.SistemaVeterinario.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {

    @Id
    private String id;
    private String usuario;
    private String senha;

}
