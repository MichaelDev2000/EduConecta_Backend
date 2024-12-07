package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	private String usuarioId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_biografia")
	private String usuBiografia;

	@Column(name="usu_contrasena")
	private String usuContrasena;

	@Column(name="usu_correo")
	private String usuCorreo;

	@Lob
	@Column(name="usu_imgperfil")
	private String usuImgperfil;

	@Column(name="usu_nombres")
	private String usuNombres;

	@Column(name="usu_status")
	private int usuStatus;

	//bi-directional many-to-one association to Amistad
	@OneToMany(mappedBy="usuario1")
	private List<Amistad> amistades1;

	//bi-directional many-to-one association to Amistad
	@OneToMany(mappedBy="usuario2")
	private List<Amistad> amistades2;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="usuario1")
	private List<Chat> chats1;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="usuario2")
	private List<Chat> chats2;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="usuario")
	private List<Like> likes;

	//bi-directional many-to-one association to Mensageschat
	@OneToMany(mappedBy="usuario")
	private List<Mensageschat> mensageschats;

	//bi-directional many-to-one association to Miembrosgrupo
	@OneToMany(mappedBy="usuario")
	private List<Miembrosgrupo> miembrosgrupos;

	//bi-directional many-to-one association to Notificacion
	@OneToMany(mappedBy="usuario")
	private List<Notificacion> notificaciones;

	//bi-directional many-to-one association to Peticionesamistad
	@OneToMany(mappedBy="usuario1")
	private List<Peticionesamistad> peticionesamistads1;

	//bi-directional many-to-one association to Peticionesamistad
	@OneToMany(mappedBy="usuario2")
	private List<Peticionesamistad> peticionesamistads2;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="usuario")
	private List<Publicacion> publicaciones;

	//bi-directional many-to-one association to Temasinteresusuario
	@OneToMany(mappedBy="usuario")
	private List<Temasinteresusuario> temasinteresusuarios;

	public Usuario() {
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public String getUsuBiografia() {
		return this.usuBiografia;
	}

	public void setUsuBiografia(String usuBiografia) {
		this.usuBiografia = usuBiografia;
	}

	public String getUsuContrasena() {
		return this.usuContrasena;
	}

	public void setUsuContrasena(String usuContrasena) {
		this.usuContrasena = usuContrasena;
	}

	public String getUsuCorreo() {
		return this.usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

	public String getUsuImgperfil() {
		return this.usuImgperfil;
	}

	public void setUsuImgperfil(String usuImgperfil) {
		this.usuImgperfil = usuImgperfil;
	}

	public String getUsuNombres() {
		return this.usuNombres;
	}

	public void setUsuNombres(String usuNombres) {
		this.usuNombres = usuNombres;
	}

	public int getUsuStatus() {
		return this.usuStatus;
	}

	public void setUsuStatus(int usuStatus) {
		this.usuStatus = usuStatus;
	}

	

}