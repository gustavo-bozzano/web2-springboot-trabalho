package com.web2.web2springboottrabalho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web2.web2springboottrabalho.models.Aluno;
import com.web2.web2springboottrabalho.repository.AlunoRepository;

@RestController
@RequestMapping(value = { "/alunos" }, method = RequestMethod.POST)
public class AlunoController {

    // private AlunoRepository repository;

    // AlunoController(AlunoRepository alunoRepository) {
    //     this.repository = alunoRepository;
    // }

    // @GetMapping
    // public List findAll() {
    //     return repository.findAll();
    // }

    // @GetMapping(path = { "/{id}" })
    // public ResponseEntity findById(@PathVariable Integer id) {
    //     return repository.findById(id)
    //             .map(record -> ResponseEntity.ok().body(record))
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // @PutMapping(value = "/{id}")
    // public ResponseEntity update(@PathVariable("id") Integer id,
    //         @RequestBody Aluno aluno) {
    //     return repository.findById(id)
    //             .map(record -> {
    //                 record.setName(contact.getName());
    //                 record.setEmail(contact.getEmail());
    //                 record.setPhone(contact.getPhone());
    //                 Contact updated = repository.save(record);
    //                 return ResponseEntity.ok().body(updated);
    //             }).orElse(ResponseEntity.notFound().build());
    // }

    // @PostMapping(path = { "/criar" })
    // public Aluno create(@RequestBody Aluno aluno) {
    //     return repository.save(aluno);
    // }
}