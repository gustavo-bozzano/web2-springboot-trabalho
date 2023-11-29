package com.web2.web2springboottrabalho.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/alunoTurma") // Alterei a URL para "/alunoTurma"
	public ResponseEntity<String> create(@RequestBody AlunoTurma aluno) {
		try {
			AlunoTurma alunoTurma = repository.save(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoTurma.toString());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO, CHAVE ESTRANGEIRA NULA\n");
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoTurma> update(@PathVariable("id") Integer id, @RequestBody AlunoTurma aluno) {
		return repository.findById(id).map(record -> {
			record.setAlunoId(aluno.getAlunoId());
			record.setTurmaId(aluno.getTurmaId());
			AlunoTurma updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
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

	@GetMapping("/alunosOrdenado")
	public String[] findAllAlunoOrder() {
		List<Aluno> alunos = alunoRepository.findAll();
		String[] ordenado = new String[alunos.size()];
		for (int i = 0; i < alunos.size(); i++) {
			ordenado[i] = alunos.get(i).getNome();
		}
		Arrays.sort(ordenado);
		return ordenado;
	}

	@GetMapping(path = { "/alunos/{id}" })
	public ResponseEntity<?> findByIdAluno(@PathVariable Integer id) {
		return alunoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/aluno") // URL original para criar aluno
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@PutMapping(value = "/alunos/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable("id") Integer id, @RequestBody Aluno aluno) {
		return alunoRepository.findById(id).map(record -> {
			record.setNome(aluno.getNome());
			Aluno updated = alunoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/alunos/{id}" })
	public ResponseEntity<?> deleteAluno(@PathVariable Integer id) {
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

	@GetMapping("/turmasOrdenado")
	public String[] findAllTurmaOrder() {
		List<Turma> turmas = turmaRepository.findAll();
		String[] ordenado = new String[turmas.size()];
		for (int i = 0; i < turmas.size(); i++) {
			ordenado[i] = turmas.get(i).getNome();
		}
		Arrays.sort(ordenado);
		return ordenado;
	}

	@GetMapping(path = { "/turmas/{id}" })
	public ResponseEntity<?> findByIdTurma(@PathVariable Integer id) {
		return turmaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/turma") // URL original para criar turma
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@PutMapping(value = "/turmas/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable("id") Integer id, @RequestBody Turma turma) {
		return turmaRepository.findById(id).map(record -> {
			record.setNome(turma.getNome());
			Turma updated = turmaRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/turmas/{id}" })
	public ResponseEntity<?> deleteTurma(@PathVariable Integer id) {
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
