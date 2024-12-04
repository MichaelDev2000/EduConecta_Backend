package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the amistades database table.
 * 
 */
@Entity
@Table(name="amistades")
@NamedQuery(name="Amistad.findAll", query="SELECT a FROM Amistad a")
public class Amistad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="amistad_id")
	private String amistadId;

	@Column(name="created_at")
	private Timestamp createdAt;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario1_id")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario2_id")
	private Usuario usuario2;

	public Amistad() {
	}

	public String getAmistadId() {
		return this.amistadId;
	}

	public void setAmistadId(String amistadId) {
		this.amistadId = amistadId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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