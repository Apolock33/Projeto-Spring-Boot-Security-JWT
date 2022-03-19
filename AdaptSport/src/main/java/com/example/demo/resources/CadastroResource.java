package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cadastro;
import com.example.demo.services.CadastroService;

@RestController
@RequestMapping(name = "/cadastro")
@CrossOrigin(origins = "http://localhost:3000/")
@EnableMethodSecurity(prePostEnabled = true)
public class CadastroResource {
	
	@Autowired
	private CadastroService service;
	
	@GetMapping("/cadastro")
	public List<Cadastro> findAll() {
		return service.findAll();
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Cadastro> save(@RequestBody Cadastro cadastro) {
		service.save(cadastro);
		return ResponseEntity.ok().body(cadastro);
	}
	
	@DeleteMapping("/cadastro/{id}")
	@PreAuthorize("hasRole('ADIMIN')")
	public ResponseEntity<Cadastro> delete(@PathVariable Long id) {
		service.delete(id);
		Cadastro cadastro = service.getBy(id);
		return ResponseEntity.ok().body(cadastro);
	}
	
	@PutMapping(value = "/cadastro/{id}")
	public ResponseEntity<Cadastro> update(@RequestBody Cadastro cadastro) {
		service.save(cadastro);
		return ResponseEntity.ok().body(cadastro);
	}
}
