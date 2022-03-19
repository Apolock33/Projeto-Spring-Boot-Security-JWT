package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Locais;
import com.example.demo.repositories.LocaisRepository;

@Service
public class LocaisService {
	
	@Autowired
	private LocaisRepository repository;
	
	@Transactional(readOnly = true)
	public List<Locais> findAll() {
		List<Locais> resultado = repository.findAll();
		return resultado;
	}
	
	public void save(Locais locais) {
		repository.save(locais);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Locais getBy(Long id) {
		return null;
	}
}
