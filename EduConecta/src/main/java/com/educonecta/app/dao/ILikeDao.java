package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Like;

@Repository
public interface ILikeDao {
	List<Like> ListarLikes();
	Like buscarPorId(String id);
	boolean registrarlike(Like like);
	boolean borrarLikeById(String id);
	boolean actualizarLike(Like like);

}
