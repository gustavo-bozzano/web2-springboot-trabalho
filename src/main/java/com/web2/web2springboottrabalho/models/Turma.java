package com.web2.web2springboottrabalho.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Turma {
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
