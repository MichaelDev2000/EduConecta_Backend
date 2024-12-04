package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Comentario;
import com.educonecta.app.jpa.IComentarioJpa;

@Repository
public class ComentarioDao implements IComentarioDao {
	
	@Autowired
	IComentarioJpa jpa;

	@Override
	public List<Comentario> ListarComentarios() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Comentario buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		comentario.setComentarioId(uuid.toString());
		if(!jpa.save(comentario).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarComentarioById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		Comentario comentarioEdit = jpa.findById(comentario.getComentarioId()).get();
		comentarioEdit.setComentarioId(comentario.getComentarioId());
		if(!jpa.save(comentarioEdit).equals(null)) return true;
		return false;
	}

}
