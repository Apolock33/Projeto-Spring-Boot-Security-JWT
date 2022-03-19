package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Cadastro;
import com.example.demo.repositories.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository repository;
	
	@Transactional(readOnly = true)
	public List<Cadastro> findAll() {
		List<Cadastro> resultado = repository.findAll();
		return resultado;
	}
	
	public void save(Cadastro cadastro) {
		repository.save(cadastro);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Cadastro getBy(Long id) {
		return null;
	}
}
