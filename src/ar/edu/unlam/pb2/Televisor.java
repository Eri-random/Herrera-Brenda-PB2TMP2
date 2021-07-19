package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Electrodomestico;

public class Televisor extends Producto implements Electrodomestico {
	
	private Integer pulgadas;
	private Integer garantia;

	public Televisor(Integer codigo, String descripcion, Integer pulgadas, Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.pulgadas=pulgadas;
		this.garantia=garantia;
	}

	public Integer getPulgadas() {
		return this.pulgadas;
	}

	@Override
	public Integer getGarantia() {
		return this.garantia;
	}

}
