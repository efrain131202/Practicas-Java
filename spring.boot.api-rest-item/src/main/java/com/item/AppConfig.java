package com.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("clienteRest")
	RestTemplate registrRestTemplate() {
		return new RestTemplate();
	}
	
	

}
