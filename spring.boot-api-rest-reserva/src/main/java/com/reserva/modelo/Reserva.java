package com.reserva.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {

	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "HABITACION")
	private int habitacion;
	@Column(name = "DISPONIBILIDAD")
	private String disponibilidad;

	public Reserva() {
		super();
	}

	public Reserva(int id, String nombre, int habitacion, String disponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habitacion = habitacion;
		this.disponibilidad = disponibilidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(int habitacion) {
		this.habitacion = habitacion;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
