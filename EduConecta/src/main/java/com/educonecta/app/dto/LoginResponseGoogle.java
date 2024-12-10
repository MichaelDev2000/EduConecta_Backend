package com.educonecta.app.dto;

public class LoginResponseGoogle {
    private String token;
    private UsuarioDTO usuario;

    public LoginResponseGoogle(String token, UsuarioDTO usuario) {
        this.token = token;
        this.usuario = usuario;
    }

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

}
