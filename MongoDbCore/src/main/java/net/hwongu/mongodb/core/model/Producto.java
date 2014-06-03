package net.hwongu.mongodb.core.model;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Henry Joe Wong Urquiza
 * @mail hwongu@gmail.com
 */
@Document
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private BigInteger id;
	private String nombre;
	private Double precio;
	private Categoria categoria;

	public Producto() {
	}

	public Producto(BigInteger id, String nombre, Double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
