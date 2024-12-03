package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.ITemaAcademicoDao;
import com.educonecta.app.entity.Temaacademico;

@Service
public class TemaAcademicoService implements ITemaAcademicoService{
	
	@Autowired
	ITemaAcademicoDao dao;

	@Override
	public List<Temaacademico> ListarTodosTemas() {
		return dao.ListarTemas();
	}

	@Override
	public Temaacademico buscarTemaPorId(String id) {
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarTema(Temaacademico tema) {
		return dao.registrarTema(tema);
	}

	@Override
	public boolean borrarTemaId(String id) {
		return dao.borrarTema(id);
	}

	@Override
	public boolean actualizarTema(Temaacademico tema) {
		return dao.actualizarTema(tema);
	}

}
