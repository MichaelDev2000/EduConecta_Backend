package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rol;

	@Column(name="rol_id")
	private String rolId;

	@Column(name="usu_correo")
	private String usuCorreo;

	public Rol() {
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getRolId() {
		return this.rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getUsuCorreo() {
		return this.usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

}