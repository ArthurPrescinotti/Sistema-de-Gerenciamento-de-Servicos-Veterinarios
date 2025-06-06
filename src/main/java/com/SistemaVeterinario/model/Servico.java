package com.SistemaVeterinario.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "servicos")
@Getter @Setter
public class Servico {

    @Id
    private String id;
    private Date data;
    private String tipo;
    private double valor;
    private String status;

    @OneToOne
    private Animal animal;
}
