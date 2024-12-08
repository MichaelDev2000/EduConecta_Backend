package com.educonecta.app.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Comentario;

public interface IComentarioJpa extends JpaRepository<Comentario, String> {
	List<Comentario> findByPublicacion_PostId(String postId);
}
