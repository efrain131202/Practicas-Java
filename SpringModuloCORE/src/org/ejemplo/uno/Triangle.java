package org.ejemplo.uno;

/*
 * EJEMPLO: INYECCION DE DEPENDENCIAS POR EL METODO CONSTRUCTOR
 * 
 * INYECCION DE DEPENDENCIAS ES CREAR INSTANCIAS UNICAS DE LA CLASE PARA EL BAJO ACOPLAMIENTO
 * 
 */
public class Triangle {

	private int height;
	private String type;
	
	
	//CONSTRUCTORS METHODS
	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Triangle(int height) {
		super();
		this.height = height;
	}

	public Triangle(int height, String type) {
		super();
		this.height = height;
		this.type = type;
	}
	
	//GETTERS AND SETTERS
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//METODO DE IMPRIMIR
	@Override
	public String toString() {
		return "Triangle [height=" + height + ", type=" + type + "]";
	}
	
}
