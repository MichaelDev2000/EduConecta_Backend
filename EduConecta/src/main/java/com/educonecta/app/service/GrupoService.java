package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IGrupoDao;
import com.educonecta.app.entity.Grupo;


@Service
public class GrupoService implements IGrupoService {

	@Autowired
	IGrupoDao dao;

	@Override
	public List<Grupo> ListarTodosGrupos() {
		// TODO Auto-generated method stub
		return dao.ListarGrupos();
	}

	@Override
	public Grupo buscarGrupoPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return dao.registrarGrupo(grupo);
	}

	@Override
	public boolean borrarGrupoId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarGrupoById(id);
	}

	@Override
	public boolean actualizarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return dao.actualizarGrupo(grupo);
	}
}
