package org.dao.inventario;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.inventario.Inventario;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImpInventario implements DaoInventario {

	@SessionTarget
	private Session session;

	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addInventario(Inventario inventario) {
		try {
			session.saveOrUpdate(inventario);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventario> listInventarios() {
		List<Inventario> list = null;
		try {
			list = (List<Inventario>) session.createQuery("from Inventario").list();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
		return list;
	}

	@Override
	public Inventario getInventarioById(int id) {
		Inventario inventario = null;
		try {
			inventario = (Inventario) session.get(Inventario.class, id);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
		return inventario;
	}

	@Override
	public void deleteInventario(int id) {
		Inventario inventario = null;
		try {
			inventario = (Inventario) session.get(Inventario.class, id);
			session.delete(inventario);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
	}

}
