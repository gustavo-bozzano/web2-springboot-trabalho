package com.web2.web2springboottrabalho.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web2.web2springboottrabalho.models.Aluno;
import com.web2.web2springboottrabalho.models.AlunoTurma;
import com.web2.web2springboottrabalho.models.Turma;
import com.web2.web2springboottrabalho.repository.AlunoRepository;
import com.web2.web2springboottrabalho.repository.EscolaRepository;
import com.web2.web2springboottrabalho.repository.TurmaRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController

public class EscolaController {
	private EscolaRepository repository;
	private AlunoRepository alunoRepository;
	private TurmaRepository turmaRepository;

	@Autowired
	EscolaController(EscolaRepository escolaRepository, AlunoRepository alunoRepository,
			TurmaRepository turmaRepository) {
		this.repository = escolaRepository;
		this.alunoRepository = alunoRepository;
		this.turmaRepository = turmaRepository;
	}

	@GetMapping("/alunoTurma")
	public List<?> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/alunoTurma") // Alterei a URL para "/alunoTurma"
	public AlunoTurma create(@RequestBody AlunoTurma aluno) {
		return repository.save(aluno);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoTurma> update(@PathVariable("id") long id, @RequestBody AlunoTurma aluno) {
		return repository.findById(id).map(record -> {
			record.setAlunoId(aluno.getAlunoId());
			record.setTurmaId(aluno.getTurmaId());
			AlunoTurma updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	// ALUNO

	@GetMapping("/alunos")
	public List<?> findAllAluno() {
		return alunoRepository.findAll();
	}

	@GetMapping(path = { "/alunos/{id}" })
	public ResponseEntity<?> findByIdAluno(@PathVariable long id) {
		return alunoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/aluno") // URL original para criar aluno
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@PutMapping(value = "/alunos/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable("id") long id, @RequestBody Aluno aluno) {
		return alunoRepository.findById(id).map(record -> {
			record.setId(aluno.getId());
			Aluno updated = alunoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/alunos/{id}" })
	public ResponseEntity<?> deleteAluno(@PathVariable Long id) {
		return alunoRepository.findById(id).map(record -> {
			alunoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	// TURMA

	@GetMapping("/turmas")
	public List<?> findAllTurma() {
		return turmaRepository.findAll();
	}

	@GetMapping(path = { "/turmas/{id}" })
	public ResponseEntity<?> findByIdTurma(@PathVariable long id) {
		return turmaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/turma") // URL original para criar turma
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@PutMapping(value = "/turmas/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable("id") long id, @RequestBody Turma turma) {
		return turmaRepository.findById(id).map(record -> {
			record.setId(turma.getId());
			Turma updated = turmaRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/turmas/{id}" })
	public ResponseEntity<?> deleteTurma(@PathVariable Long id) {
		return turmaRepository.findById(id).map(record -> {
			turmaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/favicon.ico")
	public void favicon(HttpServletResponse response) throws IOException {
	    // Lógica para retornar o ícone ou um recurso vazio
	    response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Retorna resposta vazia (204 No Content)
	}
}
