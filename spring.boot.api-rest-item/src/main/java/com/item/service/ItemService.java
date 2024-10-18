package com.item.service;

import java.util.List;

import com.item.modelo.Item;

public interface ItemService {
	
	public List<Item> findAllItem();
		public Item findByIdItem(int id, Integer cantidad);
	

}
