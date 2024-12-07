package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.ITemaInteresUsuarioDao;
import com.educonecta.app.entity.Temasinteresusuario;

@Service
public class TemaInteresUsuarioService implements ITemaInteresUsuarioService{
	
	@Autowired
	ITemaInteresUsuarioDao dao;

	@Override
	public List<Temasinteresusuario> ListarTodosTemasDeInteres() {
		return dao.ListarTemas();
	}

	@Override
	public Temasinteresusuario buscarTemaPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarTema(Temasinteresusuario tema) {
		// TODO Auto-generated method stub
		return dao.registrarTema(tema);
	}

	@Override
	public boolean borrarTemaId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarTema(id);
	}



}
