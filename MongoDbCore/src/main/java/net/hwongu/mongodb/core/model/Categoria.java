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
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private BigInteger id;
	private String nombre;

	public Categoria() {
	}

	public Categoria(BigInteger id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

}
