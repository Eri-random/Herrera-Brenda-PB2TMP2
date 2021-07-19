package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.exception.ProductoInexistente;
import ar.edu.unlam.pb2.exception.ProductoSinStock;
import ar.edu.unlam.pb2.interfaces.Comestible;

public class Supermercado {

	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el número de venta)
	private Map<Integer, Integer>carrito;
	Integer contadorDeVentas=0; // Identificador del número de venta

	public Supermercado(String nombre) {
		this.productosExistentes = new HashSet<>();
		this.productosDisponibles = new ArrayList<>();
		this.ventasRealizadas = new HashMap<>();
		this.carrito= new HashMap<>();
	}

	public void ingresarProducto(Producto nuevo) {
		this.productosDisponibles.add(nuevo);
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		this.productosExistentes.addAll(productosDisponibles);
		return this.productosExistentes;
	}

	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer stock = 0;

		for (Producto producto : productosDisponibles) {
			if (producto.getCodigo().equals(codigo)) {
				stock++;
			}
		}

		return stock;
	}

	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente {
		// Verifica si un producto existe
		for (Producto producto : productosExistentes) {
			if (producto.getCodigo().equals(codigoDeProducto)) {
				return true;
			}
		}
		throw new ProductoInexistente("El producto no existe");
	}

	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto

		for (Producto producto : productosDisponibles) {
			if (producto.getCodigo().equals(codigoDeProducto)) {
				return producto;
			}
		}
		throw new ProductoSinStock("producto sin stock");
	}
	

	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}

	public Venta getVenta(Integer nueroDeVenta) {
		// Devuelve una venta en función de su número identificatorio
		return this.ventasRealizadas.get(nueroDeVenta);
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto)
			throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el
		// "numeroDeVenta", el producto identificado por el "codigoDeProducto"
		if(this.productoExiste(codigoDeProducto) && this.getProductoPorCodigo(codigoDeProducto) == null) {
			this.carrito.put(numeroDeVenta, codigoDeProducto);
		}
		
	}
	
	public List<Producto> getProductosComestibles(){
		List <Producto> comestibles = new ArrayList<>();
		
		for (Producto producto : productosDisponibles) {
			if(producto instanceof Comestible) {
				comestibles.add(producto);
			}
		}
		return comestibles;
	}
	
	

}
