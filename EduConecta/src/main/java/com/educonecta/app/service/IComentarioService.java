package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Comentario;


public interface IComentarioService {
	List<Comentario> ListarTodosComentarios();
	Comentario buscarComentarioPorId(String id);
	boolean registrarComentario(Comentario comentario);
	boolean borrarComentarioId(String id);
	boolean actualizarComentario(Comentario comentario);
}
