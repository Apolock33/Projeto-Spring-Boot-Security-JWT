package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entities.Contato;
import com.example.demo.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Contato> findAll() {
		List<Contato> resultado = repository.findAll();
		return resultado;
	}
	
	public void save(Contato contato) {
		repository.save(contato);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Contato getById(Long id) {
		return null;
	}
}
