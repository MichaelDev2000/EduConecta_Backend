package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.ILikeDao;
import com.educonecta.app.entity.Like;

@Service
public class LikeService implements ILikeService {
	@Autowired
	ILikeDao dao;

	@Override
	public List<Like> ListarTodosLikes() {
		// TODO Auto-generated method stub
		return dao.ListarLikes();
	}

	@Override
	public Like buscarLikePorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarLike(Like like) {
		// TODO Auto-generated method stub
		return dao.registrarlike(like);
	}

	@Override
	public boolean borrarLikeId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarLikeById(id);
	}

	@Override
	public boolean actualizarLike(Like like) {
		// TODO Auto-generated method stub
		return dao.actualizarLike(like);
	}

}
