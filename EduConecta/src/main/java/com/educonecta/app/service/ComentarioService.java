package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IComentarioDao;
import com.educonecta.app.entity.Comentario;

@Service
public class ComentarioService implements IComentarioService{
	
	@Autowired
	IComentarioDao dao;

	@Override
	public List<Comentario> ListarTodosComentarios() {
		// TODO Auto-generated method stub
		return dao.ListarComentarios();
	}

	@Override
	public Comentario buscarComentarioPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return dao.registrarComentario(comentario);
	}

	@Override
	public boolean borrarComentarioId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarComentarioById(id);
	}

	@Override
	public boolean actualizarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return dao.actualizarComentario(comentario);
	}

}
