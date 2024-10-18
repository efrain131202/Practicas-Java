package org.dao.empleado;

import java.util.List;

import org.modelo.empleado.Empleado;

public interface DaoEmpleado {
	
	public void addEmpleado(Empleado empleado);
	public Empleado getEmpleadoById(int id);
	public void deleteEmpleado(int id);
	public List<Empleado> listEmpleados();

}
