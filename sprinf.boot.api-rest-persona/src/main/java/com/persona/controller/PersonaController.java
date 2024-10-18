package com.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;

//http://localhost:7575/swagger-ui/index.html

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "personas" })
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	// http://localhost:7575/personas/listar
	@GetMapping("listar")
	public List<Persona> listarPersonas() {
		List<Persona> personas = (List<Persona>) personaRepository.findAll();
		return personas;
	}

	// http://localhost:7575/personas
	@PostMapping
	public Persona addPersona(@RequestBody Persona persona) {
		return personaRepository.save(persona);
	}

	// http://localhost:7575/personas/110
	@GetMapping("/{id}")
	public Optional<Persona> getPersonaById(@PathVariable int id) {
		return personaRepository.findById(id);
	}

	// http://localhost:7575/personas/110
	@PutMapping("/{id}")
	public Persona updatePersona(@RequestBody Persona persona, @PathVariable int id) {
		persona.setId(id);
		return personaRepository.save(persona);

	}

	// http://localhost:7575/personas/107
	@DeleteMapping("/{id}")
	public void deletePersona(@PathVariable int id) {
		personaRepository.deleteById(id);
	}

}
