package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Like;
import com.educonecta.app.jpa.ILikeJpa;

@Repository
public class LikeDao implements ILikeDao {
	
	@Autowired
	ILikeJpa jpa;

	@Override
	public List<Like> ListarLikes() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Like buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarlike(Like like) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		like.setLikeId(uuid.toString());
		if(!jpa.save(like).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarLikeById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarLike(Like like) {
		// TODO Auto-generated method stub
		Like likeEdit = jpa.findById(like.getLikeId()).get();
		likeEdit.setLikeId(like.getLikeId());
		if(!jpa.save(likeEdit).equals(null)) return true;
		return false;
	}
	

}
