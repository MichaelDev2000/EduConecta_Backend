package com.educonecta.app.dto;

import java.util.List;

public class UsuarioDetallesDTO {
	private String usuarioId;
	private String usuNombres;
	private String usuApellidos;
	private String usuBiografia;
	private String usuCorreo;
	private String usuImgperfil;
	private List<PublicacionDTO> publicaciones;


	// Getters y setters
	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuNombres() {
		return usuNombres;
	}

	public void setUsuNombres(String usuNombres) {
		this.usuNombres = usuNombres;
	}

	public String getUsuApellidos() {
		return usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public String getUsuImgperfil() {
		return usuImgperfil;
	}

	public void setUsuImgperfil(String usuImgperfil) {
		this.usuImgperfil = usuImgperfil;
	}

	public String getUsuBiografia() {
		return usuBiografia;
	}

	public void setUsuBiografia(String usuBiografia) {
		this.usuBiografia = usuBiografia;
	}

	public String getUsuCorreo() {
		return usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

	public List<PublicacionDTO> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<PublicacionDTO> publicaciones) {
		this.publicaciones = publicaciones;
	}

}