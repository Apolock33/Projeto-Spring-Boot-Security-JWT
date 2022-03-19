package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_contato;
	@Column(length = 50)
	private String nome;
	@Column(length = 50)
	private String email;
	@Column(length = 1000)
	private String descricao;
	
	public Contato() {
		
	}

	public Contato(Long id_contato, String nome, String email, String descricao) {
		super();
		this.id_contato = id_contato;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_contato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id_contato, other.id_contato);
	}

	public Long getId_contato() {
		return id_contato;
	}

	public void setId_contato(Long id_contato) {
		this.id_contato = id_contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
