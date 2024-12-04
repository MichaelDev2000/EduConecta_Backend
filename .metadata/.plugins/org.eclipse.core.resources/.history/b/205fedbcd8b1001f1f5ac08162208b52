package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the temasacademicos database table.
 * 
 */
@Entity
@Table(name="temasacademicos")
@NamedQuery(name="Temaacademico.findAll", query="SELECT t FROM Temaacademico t")
public class Temaacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tema_id")
	private String temaId;

	@Column(name="tema_descripcion")
	private String temaDescripcion;

	@Column(name="tema_nombre")
	private String temaNombre;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="temasacademico")
	private List<Publicacion> publicaciones;

	//bi-directional many-to-one association to Temasinteresusuario
	@OneToMany(mappedBy="temasacademico")
	private List<Temasinteresusuario> temasinteresusuarios;

	public Temaacademico() {
	}

	public String getTemaId() {
		return this.temaId;
	}

	public void setTemaId(String temaId) {
		this.temaId = temaId;
	}

	public String getTemaDescripcion() {
		return this.temaDescripcion;
	}

	public void setTemaDescripcion(String temaDescripcion) {
		this.temaDescripcion = temaDescripcion;
	}

	public String getTemaNombre() {
		return this.temaNombre;
	}

	public void setTemaNombre(String temaNombre) {
		this.temaNombre = temaNombre;
	}

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}



	public List<Temasinteresusuario> getTemasinteresusuarios() {
		return this.temasinteresusuarios;
	}

	public void setTemasinteresusuarios(List<Temasinteresusuario> temasinteresusuarios) {
		this.temasinteresusuarios = temasinteresusuarios;
	}

	public Temasinteresusuario addTemasinteresusuario(Temasinteresusuario temasinteresusuario) {
		getTemasinteresusuarios().add(temasinteresusuario);
		temasinteresusuario.setTemasacademico(this);

		return temasinteresusuario;
	}

	public Temasinteresusuario removeTemasinteresusuario(Temasinteresusuario temasinteresusuario) {
		getTemasinteresusuarios().remove(temasinteresusuario);
		temasinteresusuario.setTemasacademico(null);

		return temasinteresusuario;
	}

}