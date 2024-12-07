package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


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

	@Lob
	@Column(name="grupo_imggrupo")
	private byte[] grupoImggrupo;

	@Column(name="grupo_nombre")
	private String grupoNombre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Miembrosgrupo
	@OneToMany(mappedBy="grupo")
	private List<Miembrosgrupo> miembrosgrupos;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="grupo")
	private List<Publicacion> publicaciones;

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

	public byte[] getGrupoImggrupo() {
		return this.grupoImggrupo;
	}

	public void setGrupoImggrupo(byte[] grupoImggrupo) {
		this.grupoImggrupo = grupoImggrupo;
	}

	public String getGrupoNombre() {
		return this.grupoNombre;
	}

	public void setGrupoNombre(String grupoNombre) {
		this.grupoNombre = grupoNombre;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Miembrosgrupo> getMiembrosgrupos() {
		return this.miembrosgrupos;
	}

	public void setMiembrosgrupos(List<Miembrosgrupo> miembrosgrupos) {
		this.miembrosgrupos = miembrosgrupos;
	}

	public Miembrosgrupo addMiembrosgrupo(Miembrosgrupo miembrosgrupo) {
		getMiembrosgrupos().add(miembrosgrupo);
		miembrosgrupo.setGrupo(this);

		return miembrosgrupo;
	}

	public Miembrosgrupo removeMiembrosgrupo(Miembrosgrupo miembrosgrupo) {
		getMiembrosgrupos().remove(miembrosgrupo);
		miembrosgrupo.setGrupo(null);

		return miembrosgrupo;
	}

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacion addPublicacione(Publicacion publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setGrupo(this);

		return publicacione;
	}

	public Publicacion removePublicacione(Publicacion publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setGrupo(null);

		return publicacione;
	}

}