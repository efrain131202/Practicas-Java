package com.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/listar")
	public List<Persona> listPersonas(){
		return (List<Persona>) personaRepository.findAll();
	}
	

}
