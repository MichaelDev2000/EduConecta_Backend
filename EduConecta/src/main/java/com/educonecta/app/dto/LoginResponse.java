package com.educonecta.app.dto;

public class LoginResponse {
	private String token;
	private UsuarioDTO usuario;

	// Constructor
	public LoginResponse(String token, UsuarioDTO usuario) {
		this.token = token;
		this.usuario = usuario;
	}

	// Getters y setters
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	// Sobrescribir toString() para una representación legible
	@Override
	public String toString() {
		return "LoginResponse{" + "token='" + token + '\'' + ", usuario=" + usuario + '}';
	}
}