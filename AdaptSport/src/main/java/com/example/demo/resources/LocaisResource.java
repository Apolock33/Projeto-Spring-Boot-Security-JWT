package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Locais;
import com.example.demo.services.LocaisService;

@RestController
@RequestMapping(name = "/locais")
@CrossOrigin(origins = "http://localhost:3000/")
public class LocaisResource {
	
	@Autowired
	private LocaisService service;

	@GetMapping("/locais")
	public List<Locais> findAll() {
		return service.findAll();
	}

	@PostMapping("/locais")
	public ResponseEntity<Locais> save(@RequestBody Locais locais) {
		service.save(locais);
		return ResponseEntity.ok().body(locais);
	}

	@DeleteMapping("/locais/{id}")
	public ResponseEntity<Locais> delete(@PathVariable Long id) {
		service.delete(id);
		Locais locais = service.getBy(id);
		return ResponseEntity.ok().body(locais);
	}

	@PutMapping(value = "/locais/{id}")
	public ResponseEntity<Locais> update(@RequestBody Locais locais) {
		service.save(locais);
		return ResponseEntity.ok().body(locais);
	}
}
