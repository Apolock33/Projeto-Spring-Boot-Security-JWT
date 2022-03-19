package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_locais;
	@Column(length = 50)
	private String nome;
	@Column(length = 30)
	private String estado;
	@Column(length = 50)
	private String cidade;
	@Column(length = 100)
	private String endereco;
	@Column(length = 1000)
	private String descricao;
	@Column(length = 100)
	private String contato;
	@Column(length = 300)
	private String imagem;
	@Column(length = 100)
	private String site;
	
	public Locais() {
		
	}

	public Locais(Long id_locais, String nome, String estado, String cidade, String endereco, String descricao,
			String contato, String imagem, String site) {
		super();
		this.id_locais = id_locais;
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.descricao = descricao;
		this.contato = contato;
		this.imagem = imagem;
		this.site = site;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_locais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locais other = (Locais) obj;
		return Objects.equals(id_locais, other.id_locais);
	}

	public Long getId_locais() {
		return id_locais;
	}

	public void setId_locais(Long id_locais) {
		this.id_locais = id_locais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}
