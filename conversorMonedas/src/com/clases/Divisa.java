package com.clases;

public class Divisa {
	
	private String nombre;
	private double equivalenciaSol;
	
	public Divisa() {
	}
	
	public Divisa(String nombre, double equivalenciaDolar) {
		this.nombre = nombre;
		this.equivalenciaSol = equivalenciaDolar;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getEquivalenciaSol() {
		return equivalenciaSol;
	}

	public void setEquivalenciaSol(double equivalenciaSol) {
		this.equivalenciaSol = equivalenciaSol;
	}

}
