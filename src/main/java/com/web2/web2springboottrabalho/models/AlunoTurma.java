package com.web2.web2springboottrabalho.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;

@Entity
public class AlunoTurma {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "aluno_id", referencedColumnName = "id", table = "aluno", columnDefinition = "char(36)")
	private int alunoId;

	@JoinColumn(name = "turma_id", referencedColumnName = "id", table = "turma", columnDefinition = "char(36)")
	private int turmaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("O ID deve ser um número inteiro positivo");
		}
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		if (alunoId > 0) {
			this.alunoId = alunoId;
		} else {
			throw new IllegalArgumentException("O ID do aluno deve ser um número inteiro positivo");
		}
	}

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		if (turmaId > 0) {
			this.turmaId = turmaId;
		} else {
			throw new IllegalArgumentException("O ID da turma deve ser um número inteiro positivo");
		}
	}

	@Override
	public String toString() {
		return "AlunoTurma [id=" + id + ", alunoId=" + alunoId + ", turmaId=" + turmaId + "]";
	}
}
