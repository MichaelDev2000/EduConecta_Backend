package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the temasinteresusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Temasinteresusuario.findAll", query="SELECT t FROM Temasinteresusuario t")
public class Temasinteresusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="temasinteresusuario_id")
	private String temasinteresusuarioId;

	//bi-directional many-to-one association to Temaacademico
	@ManyToOne
	@JoinColumn(name="tema_id")
	private Temaacademico temasacademico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Temasinteresusuario() {
	}

	public String getTemasinteresusuarioId() {
		return this.temasinteresusuarioId;
	}

	public void setTemasinteresusuarioId(String temasinteresusuarioId) {
		this.temasinteresusuarioId = temasinteresusuarioId;
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

}