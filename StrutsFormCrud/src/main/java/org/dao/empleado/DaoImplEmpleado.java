package org.dao.empleado;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.empleado.Empleado;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImplEmpleado implements DaoEmpleado {

	@SessionTarget
	private Session session;

	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addEmpleado(Empleado empleado) {
		try {
			session.saveOrUpdate(empleado);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> listEmpleados() {
		List<Empleado> list = null;
		try {
			list = (List<Empleado>) session.createQuery("from Empleado").list();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
		return list;
	}

	@Override
	public Empleado getEmpleadoById(int id) {
		Empleado empleado = null;
		try {
			empleado = (Empleado) session.get(Empleado.class, id);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
		return empleado;
	}

	@Override
	public void deleteEmpleado(int id) {
		Empleado empleado = null;
		try {
			empleado = (Empleado) session.get(Empleado.class, id);
			session.delete(empleado);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}

	}
	

}
