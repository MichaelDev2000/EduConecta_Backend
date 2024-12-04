package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mensageschats database table.
 * 
 */
@Entity
@Table(name="mensageschats")
@NamedQuery(name="Mensageschat.findAll", query="SELECT m FROM Mensageschat m")
public class Mensageschat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mensage_id")
	private String mensageId;

	@Column(name="chat_id")
	private String chatId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="mensage_contenido")
	private String mensageContenido;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="enviadorUser_id")
	private Usuario usuario;

	public Mensageschat() {
	}

	public String getMensageId() {
		return this.mensageId;
	}

	public void setMensageId(String mensageId) {
		this.mensageId = mensageId;
	}

	public String getChatId() {
		return this.chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getMensageContenido() {
		return this.mensageContenido;
	}

	public void setMensageContenido(String mensageContenido) {
		this.mensageContenido = mensageContenido;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}