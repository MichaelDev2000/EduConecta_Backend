package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
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

	@Column(name="grupo_id")
	private String grupoId;

	@Column(name="post_contenido")
	private String postContenido;

	@Lob
	@Column(name="post_imgpost")
	private String postImgpost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="usuario_id")
	private String usuarioId;

	//bi-directional many-to-one association to Temaacademico
	@ManyToOne
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

	public String getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(String grupoId) {
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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Temaacademico getTemasacademico() {
		return this.temasacademico;
	}

	public void setTemasacademico(Temaacademico temasacademico) {
		this.temasacademico = temasacademico;
	}

}