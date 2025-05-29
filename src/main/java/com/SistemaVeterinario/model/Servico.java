package com.SistemaVeterinario.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Table(name = "servico")
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
