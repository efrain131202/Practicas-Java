package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.item.modelo.Item;
import com.item.service.ItemService;

@RestController
public class ItemController {
	
	
	@Autowired
	@Qualifier("itemServiceFeign")
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listarItem(){
		return itemService.findAllItem();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalleItem(@PathVariable int id, @PathVariable Integer cantidad) {
		return itemService.findByIdItem(id, cantidad);
	}

}
