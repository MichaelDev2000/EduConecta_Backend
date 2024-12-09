package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;


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

	@Column(name="created_at")
	private Timestamp createdAt;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name = "post_id")  
	private Publicacion publicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;



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

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Publicacion getPublicacione() {
		return this.publicacion;
	}

	public void setPublicacione(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	public String getPostId() {
        return publicacion.getPostId();
    }

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}