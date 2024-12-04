package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the miembrosgrupo database table.
 * 
 */
@Entity
@NamedQuery(name="Miembrosgrupo.findAll", query="SELECT m FROM Miembrosgrupo m")
public class Miembrosgrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="miembrogrupo_id")
	private String miembrogrupoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="joined_at")
	private Date joinedAt;

	@Column(name="miembro_rol")
	private String miembroRol;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Miembrosgrupo() {
	}

	public String getMiembrogrupoId() {
		return this.miembrogrupoId;
	}

	public void setMiembrogrupoId(String miembrogrupoId) {
		this.miembrogrupoId = miembrogrupoId;
	}

	public Date getJoinedAt() {
		return this.joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

	public String getMiembroRol() {
		return this.miembroRol;
	}

	public void setMiembroRol(String miembroRol) {
		this.miembroRol = miembroRol;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}