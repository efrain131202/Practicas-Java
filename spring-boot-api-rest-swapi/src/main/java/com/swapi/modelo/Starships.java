package com.swapi.modelo;

public class Starships {

	private String name;
	private String model;
	private String manufacturer;
	private String cost_in_credits;
	private String length;
	private String max_atmosphering_speed;
	private String crew;
	private String passengers;
	private String cargo_capacity;
	private String consumables;
	private String hyperdrive_rating;
	private String MGLT;
	private String starship_class;
	private String[] pilots;
	private String[] films;
	private String created;
	private String edited;
	private String url;

	public Starships() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Starships(String name, String model, String manufacturer, String cost_in_credits, String length,
			String max_atmosphering_speed, String crew, String passengers, String cargo_capacity, String consumables,
			String hyperdrive_rating, String mGLT, String starship_class, String[] pilots, String[] films,
			String created, String edited, String url) {
		super();
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.cost_in_credits = cost_in_credits;
		this.length = length;
		this.max_atmosphering_speed = max_atmosphering_speed;
		this.crew = crew;
		this.passengers = passengers;
		this.cargo_capacity = cargo_capacity;
		this.consumables = consumables;
		this.hyperdrive_rating = hyperdrive_rating;
		MGLT = mGLT;
		this.starship_class = starship_class;
		this.pilots = pilots;
		this.films = films;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost_in_credits() {
		return cost_in_credits;
	}

	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getCargo_capacity() {
		return cargo_capacity;
	}

	public void setCargo_capacity(String cargo_capacity) {
		this.cargo_capacity = cargo_capacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public String getHyperdrive_rating() {
		return hyperdrive_rating;
	}

	public void setHyperdrive_rating(String hyperdrive_rating) {
		this.hyperdrive_rating = hyperdrive_rating;
	}

	public String getMGLT() {
		return MGLT;
	}

	public void setMGLT(String mGLT) {
		MGLT = mGLT;
	}

	public String getStarship_class() {
		return starship_class;
	}

	public void setStarship_class(String starship_class) {
		this.starship_class = starship_class;
	}

	public String[] getPilots() {
		return pilots;
	}

	public void setPilots(String[] pilots) {
		this.pilots = pilots;
	}

	public String[] getFilms() {
		return films;
	}

	public void setFilms(String[] films) {
		this.films = films;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
