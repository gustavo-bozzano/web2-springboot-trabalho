package com.web2.web2springboottrabalho.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class AlunoTurma {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "aluno_id", referencedColumnName = "id", table = "aluno", columnDefinition = "char(36)")
    private String alunoId;

    @JoinColumn(name = "turma_id", referencedColumnName = "id", table = "turma", columnDefinition = "char(36)")
    private String turmaId;
}
