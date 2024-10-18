package com.swapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swapi.modelo.Starships;

@Service
public class StarshipsServiceImpl implements StarshipsService {
	
	private RestTemplate clientRest = new RestTemplate();
	
	@Override
	public Starships findByIdStarships(int id) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", Integer.toString(id));
        Starships starships = clientRest.getForObject("https://swapi.dev/api/starships/{id}", Starships.class, pathVariables);
        return starships;
    }
	
	

}
