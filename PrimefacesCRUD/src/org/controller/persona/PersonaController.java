package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@ManagedBean
@ViewScoped
public class PersonaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Persona persona;
	
	private List<Persona> listaPersonas;
	
	//CONSTRUCTOR
	public PersonaController() {
		persona = new Persona();
	}

	public List<Persona> getListaPersonas() {
		DaoPersona dao = new DaoPersona();
		listaPersonas = dao.listPersona(persona);
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	//QUERIES METHOS HTTP
	public void limpiarPersona() {
		persona = new Persona();
	}
	
	
	public String agregarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.addPersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String modificarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.updatePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String eliminarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.deletePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	
	
}
