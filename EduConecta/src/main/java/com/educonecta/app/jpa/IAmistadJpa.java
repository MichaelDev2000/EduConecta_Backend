package com.educonecta.app.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Amistad;

public interface IAmistadJpa extends JpaRepository<Amistad, String>{
	List<Amistad> findByUsuario1_UsuarioIdOrUsuario2_UsuarioId(String usuario1Id, String usuario2Id);
}
