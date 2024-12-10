package com.educonecta.app.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.educonecta.app.entity.Usuario;

public class UsuarioDTO {
    
    private String usuarioId;
    private String usuApellidos;
    private String usuBiografia;
    private String usuCorreo;
    private String usuImgperfil;
    private String usuNombres;
    private int usuStatus;
    
    public UsuarioDTO() {
	}
    
    public UsuarioDTO(Usuario usuario) {
        this.usuarioId = usuario.getUsuarioId();
        this.usuApellidos = usuario.getUsuApellidos();
        this.usuBiografia = usuario.getUsuBiografia();
        this.usuCorreo = usuario.getUsuCorreo();
        this.usuImgperfil = usuario.getUsuImgperfil();
        this.usuNombres = usuario.getUsuNombres();
        this.usuStatus = usuario.getUsuStatus();
    }
    

    public String getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getUsuApellidos() {
        return usuApellidos;
    }
    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
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
    public String getUsuImgperfil() {
        return usuImgperfil;
    }
    public void setUsuImgperfil(String usuImgperfil) {
        this.usuImgperfil = usuImgperfil;
    }
    public String getUsuNombres() {
        return usuNombres;
    }
    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }
    public Integer getUsuStatus() {
        return usuStatus;
    }
    public void setUsuStatus(Integer usuStatus) {
        this.usuStatus = usuStatus;
    }

    // Método toString corregido
    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "usuarioId='" + usuarioId + '\'' +
                ", usuApellidos='" + usuApellidos + '\'' +
                ", usuBiografia='" + usuBiografia + '\'' +
                ", usuCorreo='" + usuCorreo + '\'' +
                ", usuImgperfil=" + (usuImgperfil != null ? "[byte data]" : "null") +
                ", usuNombres='" + usuNombres + '\'' +
                ", usuStatus=" + usuStatus +
                '}';
    }
}

