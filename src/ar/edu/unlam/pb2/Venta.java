package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	
	private Integer dniDelComprador;
	private String nombreDelComprador;
	
	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		this.dniDelComprador= dniDelComprador;
		this.nombreDelComprador=nombreDelComprador;
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}

	public void setDniDelComprador(Integer dniDelComprador) {
		this.dniDelComprador = dniDelComprador;
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public void setNombreDelComprador(String nombreDelComprador) {
		this.nombreDelComprador = nombreDelComprador;
	}

	

	
	
	


	
	
	

}
