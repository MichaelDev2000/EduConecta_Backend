package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


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

	@Column(name="post_contenido")
	private String postContenido;

	@Lob
	@Column(name="post_imgpost")
	private String postImgpost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="publicacione")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="publicacione")
	private List<Like> likes;

	//bi-directional many-to-one association to Temaacademico
	@ManyToOne
	@JoinColumn(name="tema_id")
	private Temaacademico temasacademico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;

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

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPublicacione(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPublicacione(null);

		return comentario;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setPublicacione(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setPublicacione(null);

		return like;
	}

	public Temaacademico getTemasacademico() {
		return this.temasacademico;
	}

	public void setTemasacademico(Temaacademico temasacademico) {
		this.temasacademico = temasacademico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}