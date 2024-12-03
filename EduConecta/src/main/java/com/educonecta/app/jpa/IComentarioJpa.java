package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Comentario;

public interface IComentarioJpa extends JpaRepository<Comentario, String>{

}
