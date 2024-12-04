package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comentario_id")
	private String comentarioId;

	@Column(name="coment_contenido")
	private String comentContenido;

	private String comentarioParent_id;

	@Column(name="created_at")
	private Timestamp createdAt;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="post_id")
	private Publicacion publicacione;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	//bi-directional one-to-one association to Comentario
	@OneToOne
	@JoinColumn(name="comentario_id")
	private Comentario comentario1;

	//bi-directional one-to-one association to Comentario
	@OneToOne(mappedBy="comentario1")
	private Comentario comentario2;

	public Comentario() {
	}

	public String getComentarioId() {
		return this.comentarioId;
	}

	public void setComentarioId(String comentarioId) {
		this.comentarioId = comentarioId;
	}

	public String getComentContenido() {
		return this.comentContenido;
	}

	public void setComentContenido(String comentContenido) {
		this.comentContenido = comentContenido;
	}

	public String getComentarioParent_id() {
		return this.comentarioParent_id;
	}

	public void setComentarioParent_id(String comentarioParent_id) {
		this.comentarioParent_id = comentarioParent_id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Publicacion getPublicacione() {
		return this.publicacione;
	}

	public void setPublicacione(Publicacion publicacione) {
		this.publicacione = publicacione;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentario1() {
		return this.comentario1;
	}

	public void setComentario1(Comentario comentario1) {
		this.comentario1 = comentario1;
	}

	public Comentario getComentario2() {
		return this.comentario2;
	}

	public void setComentario2(Comentario comentario2) {
		this.comentario2 = comentario2;
	}

}