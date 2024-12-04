package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Comentario;

@Repository
public interface IComentarioDao {
	List<Comentario> ListarComentarios();
	Comentario buscarPorId(String id);
	boolean registrarComentario(Comentario comentario);
	boolean borrarComentarioById(String id);
	boolean actualizarComentario(Comentario comentario);
	
}
