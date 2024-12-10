package com.educonecta.app.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Peticionesamistad;

public interface IPeticionAmistadJpa extends JpaRepository<Peticionesamistad, String> {
	List<Peticionesamistad> findByUsuario2_UsuarioIdAndPeticionEstado(String idUsuarioDestino, String peticionEstado);

}
