package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Comestible;

public class Galletitas extends Producto implements Comestible {
	
	private String fechaDeElaboracion;
	private String fechaDeVencimiento;

	public Galletitas(Integer codigo, String descripcion, String fechaDeElaboracion, String fechaDeVencimiento,  String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.fechaDeElaboracion= fechaDeElaboracion;
		this.fechaDeVencimiento=fechaDeVencimiento;
	}

	@Override
	public String getFechaDeElaboracion() {
		return this.fechaDeElaboracion;
	}

	@Override
	public String getFechaDeVencimiento() {
		return this.fechaDeVencimiento;
	}


	
	
	

}
