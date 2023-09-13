package com.web2.web2springboottrabalho.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome não pode ser vazio.")
    @NotBlank(message = "Nome não pode ser branco.")
    @NotNull(message = "Nome não pode ser nulo.")
    @Column(nullable = false)
    private String nome;
}