package com.web2.web2springboottrabalho.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class AlunoTurma {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "aluno_id", referencedColumnName = "id", table = "aluno", columnDefinition = "char(36)")
	private int aluno_Id;

	@JoinColumn(name = "turma_id", referencedColumnName = "id", table = "turma", columnDefinition = "char(36)")
	private int turma_Id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlunoId() {
		return aluno_Id;
	}

	public void setAlunoId(int alunoId) {
		this.aluno_Id = alunoId;
	}

	public int getTurmaId() {
		return turma_Id;
	}

	public void setTurmaId(int turmaId) {
		this.turma_Id = turmaId;
	}

	@Override
	public String toString() {
		return "AlunoTurma [id=" + id + ", aluno_Id=" + aluno_Id + ", turma_Id=" + turma_Id + "]";
	}

}