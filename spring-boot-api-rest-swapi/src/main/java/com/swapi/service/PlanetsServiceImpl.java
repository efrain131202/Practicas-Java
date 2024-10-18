package com.swapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swapi.modelo.Planets;

@Service
public class PlanetsServiceImpl implements PlanetsService {

    private RestTemplate clientRest = new RestTemplate();

    @Override
    public Planets findByIdPlanets(int id) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", Integer.toString(id));
        Planets planets = clientRest.getForObject("https://swapi.dev/api/planets/{id}", Planets.class, pathVariables);
        return planets;
    }

}

