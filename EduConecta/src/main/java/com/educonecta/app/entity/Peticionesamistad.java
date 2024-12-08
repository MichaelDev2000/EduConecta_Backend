package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the peticionesamistad database table.
 * 
 */
@Entity
@NamedQuery(name="Peticionesamistad.findAll", query="SELECT p FROM Peticionesamistad p")
public class Peticionesamistad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="peticion_id")
	private String peticionId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="peticion_estado")
	private String peticionEstado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="enviadorUsuario_id")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="receptorUsuario_id")
	private Usuario usuario2;

	public Peticionesamistad() {
	}

	public String getPeticionId() {
		return this.peticionId;
	}

	public void setPeticionId(String peticionId) {
		this.peticionId = peticionId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getPeticionEstado() {
		return this.peticionEstado;
	}

	public void setPeticionEstado(String peticionEstado) {
		this.peticionEstado = peticionEstado;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}