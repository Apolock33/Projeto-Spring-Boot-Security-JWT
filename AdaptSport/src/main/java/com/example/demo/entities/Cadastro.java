package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cadastro;
	@Column(length = 50)
	private String nome;
	@Column(length = 70)
	private String sobrenome;
	@Column(length = 100)
	private String email;
	@Column(length = 8)
	private int senha;
	
	public Cadastro() {
		
	}

	public Cadastro(Long id_cadastro, String nome, String sobrenome, String email, int senha) {
		super();
		this.id_cadastro = id_cadastro;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_cadastro, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(id_cadastro, other.id_cadastro) && senha == other.senha;
	}

	public Long getId_cadastro() {
		return id_cadastro;
	}

	public void setId_cadastro(Long id_cadastro) {
		this.id_cadastro = id_cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
}
