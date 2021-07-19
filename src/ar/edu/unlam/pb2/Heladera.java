package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Electrodomestico;

public class Heladera extends Producto implements Electrodomestico {
	
	private Integer garantia;
	private Boolean estado;

	
	public Heladera(Integer codigo, String descripcion, Boolean estado, Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.estado=estado;
		this.garantia=garantia;
	}

	@Override
	public Integer getGarantia() {
		return this.garantia;
	}

	public Boolean isNoFrost() {
		return this.estado;
	}

}
