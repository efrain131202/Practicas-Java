package org.dao.persona;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.persona.Persona;

public class DaoPersona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addPersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(persona);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	
	public void updatePersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(persona);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public void deletePersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(persona);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> listPersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Persona> listaPersona = null;
		try {
			session.beginTransaction();
			listaPersona = session.createQuery("from Persona").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return listaPersona;
	}
}
