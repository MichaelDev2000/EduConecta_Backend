package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the grupos database table.
 * 
 */
@Entity
@Table(name="grupos")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="grupo_id")
	private String grupoId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="grupo_descripcion")
	private String grupoDescripcion;

	@Column(name="grupo_img")
	private String grupoImg;

	@Column(name="grupo_nombre")
	private String grupoNombre;

	//bi-directional many-to-one association to Temaacademico
	@ManyToOne
	@JoinColumn(name="tema_id")
	private Temaacademico temasacademico;

	public Grupo() {
	}

	public String getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getGrupoDescripcion() {
		return this.grupoDescripcion;
	}

	public void setGrupoDescripcion(String grupoDescripcion) {
		this.grupoDescripcion = grupoDescripcion;
	}

	public String getGrupoImg() {
		return this.grupoImg;
	}

	public void setGrupoImg(String grupoImg) {
		this.grupoImg = grupoImg;
	}

	public String getGrupoNombre() {
		return this.grupoNombre;
	}

	public void setGrupoNombre(String grupoNombre) {
		this.grupoNombre = grupoNombre;
	}

	public Temaacademico getTemasacademico() {
		return this.temasacademico;
	}

	public void setTemasacademico(Temaacademico temasacademico) {
		this.temasacademico = temasacademico;
	}

}