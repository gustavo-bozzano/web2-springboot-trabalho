package com.web2.web2springboottrabalho.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web2.web2springboottrabalho.repository.AlunoRepository;

@RestController
@RequestMapping({ "/alunos" })
public class AlunoController {

    private AlunoRepository repository;


    AlunoController(AlunoRepository alunoRepository) {
        this.repository = alunoRepository;
    }
    // métodos do CRUD aqui

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }
}