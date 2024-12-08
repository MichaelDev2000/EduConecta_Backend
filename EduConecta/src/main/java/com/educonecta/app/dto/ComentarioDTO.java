package com.educonecta.app.dto;

public class ComentarioDTO {
	
	
	private String comentarioId;
	private String contenido;
	private String creadoEn;
	private String actualizadoEn;

	private String usuarioID;
	private String usuarioNombre;
	private String usuarioImagen;

	// Getters y setters
	public String getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(String comentarioId) {
		this.comentarioId = comentarioId;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}

	public String getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(String actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}

	public String getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getUsuarioImagen() {
		return usuarioImagen;
	}

	public void setUsuarioImagen(String usuarioImagen) {
		this.usuarioImagen = usuarioImagen;
	}
}
