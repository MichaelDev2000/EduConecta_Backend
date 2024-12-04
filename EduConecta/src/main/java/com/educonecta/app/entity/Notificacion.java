package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the notificaciones database table.
 * 
 */
@Entity
@Table(name="notificaciones")
@NamedQuery(name="Notificacion.findAll", query="SELECT n FROM Notificacion n")
public class Notificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="notificacion_id")
	private String notificacionId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="noti_tipo")
	private String notiTipo;

	@Column(name="noti_vista")
	private String notiVista;

	@Column(name="referencia_id")
	private String referenciaId;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Notificacion() {
	}

	public String getNotificacionId() {
		return this.notificacionId;
	}

	public void setNotificacionId(String notificacionId) {
		this.notificacionId = notificacionId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getNotiTipo() {
		return this.notiTipo;
	}

	public void setNotiTipo(String notiTipo) {
		this.notiTipo = notiTipo;
	}

	public String getNotiVista() {
		return this.notiVista;
	}

	public void setNotiVista(String notiVista) {
		this.notiVista = notiVista;
	}

	public String getReferenciaId() {
		return this.referenciaId;
	}

	public void setReferenciaId(String referenciaId) {
		this.referenciaId = referenciaId;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}