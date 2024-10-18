package com.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.item.modelo.Producto;

//spring.application.name=spring.boot.api-rest-item
@FeignClient(name = "spring.boot.api-rest-item", url = "localhost:7171")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable int id);

}
