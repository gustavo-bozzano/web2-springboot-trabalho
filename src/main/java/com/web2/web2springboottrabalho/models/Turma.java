package com.web2.web2springboottrabalho.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.trim().isEmpty()) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("O nome não pode estar em branco ou nulo");
		}
	}
}
