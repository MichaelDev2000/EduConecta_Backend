package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Like;

public interface ILikeService {
	List<Like> ListarTodosLikes();
	Like buscarLikePorId(String id);
	boolean registrarLike(Like like);
	boolean borrarLikeId(String id);
	boolean actualizarLike(Like like);
}
