package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the temasacademicos database table.
 * 
 */
@Entity
@Table(name="temasacademicos")
@NamedQuery(name="Temasacademico.findAll", query="SELECT t FROM Temasacademico t")
public class Temasacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tema_id")
	private String temaId;

	private String descripcion;

	private String nombre;

	public Temasacademico() {
	}

	public String getTemaId() {
		return this.temaId;
	}

	public void setTemaId(String temaId) {
		this.temaId = temaId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}