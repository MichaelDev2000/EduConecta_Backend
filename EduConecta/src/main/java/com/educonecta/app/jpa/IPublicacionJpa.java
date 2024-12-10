package com.educonecta.app.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Publicacion;

public interface IPublicacionJpa extends JpaRepository<Publicacion, String> {
	List<Publicacion> findByUsuario_UsuarioId(String usuarioId);
}
