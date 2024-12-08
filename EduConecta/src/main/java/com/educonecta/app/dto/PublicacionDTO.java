package com.educonecta.app.dto;

import java.util.List;

public class PublicacionDTO {
    private String postId;
    private String contenido;
    private String imagen;
    private String creadoEn;
    private String actualizadoEn;

    private String temaNombre;
    private String temaDescripcion;

    private String usuarioID;
    private String usuarioNombre;
    private String usuarioImagen;

    private String grupoId;
    private String grupoNombre;
    private String grupoDescripcion;

    private Long numeroLikes;
    private List<ComentarioDTO> comentarios;  // Usamos un DTO para los comentarios


    // Getters y setters
    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
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
    public String getTemaNombre() {
        return temaNombre;
    }
    public void setTemaNombre(String temaNombre) {
        this.temaNombre = temaNombre;
    }
    public String getTemaDescripcion() {
        return temaDescripcion;
    }
    public void setTemaDescripcion(String temaDescripcion) {
        this.temaDescripcion = temaDescripcion;
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
    public String getGrupoId() {
        return grupoId;
    }
    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }
    public String getGrupoNombre() {
        return grupoNombre;
    }
    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }
    public String getGrupoDescripcion() {
        return grupoDescripcion;
    }
    public void setGrupoDescripcion(String grupoDescripcion) {
        this.grupoDescripcion = grupoDescripcion;
    }
    public Long getNumeroLikes() {
        return numeroLikes;
    }
    public void setNumeroLikes(Long numeroLikes) {
        this.numeroLikes = numeroLikes;
    }
    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }
    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
