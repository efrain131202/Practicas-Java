package org.dao.inventario;

import java.util.List;

import org.modelo.inventario.Inventario;

public interface DaoInventario {
	
	public void addInventario(Inventario inventario);
	public Inventario getInventarioById(int id);
	public void deleteInventario(int id);
	public List<Inventario> listInventarios();

}
