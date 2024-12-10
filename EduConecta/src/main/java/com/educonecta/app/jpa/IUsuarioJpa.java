package com.educonecta.app.jpa;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Usuario;


public interface IUsuarioJpa extends JpaRepository<Usuario, String>{
	Usuario findByUsuCorreo(String usuCorreo);
}
