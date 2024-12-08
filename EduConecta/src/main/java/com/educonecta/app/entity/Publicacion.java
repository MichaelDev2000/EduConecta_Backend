package com.educonecta.app.entity;

import java.io.Serializable;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@Table(name="publicaciones")
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="post_id")
	private String postId;

	@Column(name="created_at")
	private Timestamp createdAt;

	
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupoId;

	@Column(name="post_contenido")
	private String postContenido;

	@Lob
	@Column(name="post_imgpost")
	private String postImgpost;

	@ManyToOne
	@JsonProperty("usuarioId")
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	//bi-directional many-to-one association to Temaacademico
	@ManyToOne
	@JsonProperty("temaId")
	@JoinColumn(name="tema_id")
	private Temaacademico temasacademico;

	public Publicacion() {
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Grupo getGrupoId() {
	    return this.grupoId;
	}

	// Setter para grupoId (entidad Grupo)
	public void setGrupoId(Grupo grupoId) {
	    this.grupoId = grupoId;
	}

	public String getPostContenido() {
		return this.postContenido;
	}

	public void setPostContenido(String postContenido) {
		this.postContenido = postContenido;
	}

	public String getPostImgpost() {
		return this.postImgpost;
	}

	public void setPostImgpost(String postImgpost) {
		this.postImgpost = postImgpost;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	}

	public Temaacademico getTemasacademico() {
		return this.temasacademico;
	}

	public void setTemasacademico(Temaacademico temasacademico) {
	    this.temasacademico = temasacademico;
	}

}