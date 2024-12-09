package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the grupos database table.
 */
@Entity
@Table(name = "grupos")
@NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "grupo_id")
    private String grupoId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "grupo_descripcion")
    private String grupoDescripcion;

    @Lob
    @Column(name = "grupo_imggrupo")
    private byte[] grupoImggrupo;

    @Column(name = "grupo_nombre")
    private String grupoNombre;


    public Grupo() {
    }

    // Getters y setters
    public String getGrupoId() {
        return this.grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getGrupoDescripcion() {
        return this.grupoDescripcion;
    }

    public void setGrupoDescripcion(String grupoDescripcion) {
        this.grupoDescripcion = grupoDescripcion;
    }

    public byte[] getGrupoImggrupo() {
        return this.grupoImggrupo;
    }

    public void setGrupoImggrupo(byte[] grupoImggrupo) {
        this.grupoImggrupo = grupoImggrupo;
    }

    public String getGrupoNombre() {
        return this.grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

}
