package com.swapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.modelo.Planets;
import com.swapi.modelo.Starships;
import com.swapi.service.PlanetsService;
import com.swapi.service.StarshipsService;

@RestController
public class SWAPIController {

	@Autowired
	private PlanetsService planetsService;
	
	@Autowired
	private StarshipsService starshipsService;

	@GetMapping("/swapi.dev/api/planets/{id}")
	public Planets getPlanetsById(@PathVariable int id) {
		return planetsService.findByIdPlanets(id);
	}

	@GetMapping("/swapi.dev/api/starships/{id}")
	public Starships getStarships(@PathVariable int id) {
		return starshipsService.findByIdStarships(id);
	}
}
