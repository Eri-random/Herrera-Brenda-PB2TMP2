package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Indumentaria;

public class Remera extends Producto implements Indumentaria {
	
	private String talle;
	private String color;

	public Remera(Integer codigo, String descripcion,String talle, String marca, String color, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.talle=talle;
		this.color=color;
	}

	@Override
	public String getTalle() {
		return this.talle;
	}

	@Override
	public String getColor() {
		return this.color;
	}

}
