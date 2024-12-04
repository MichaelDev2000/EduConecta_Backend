package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IMiembrosGrupoDao;
import com.educonecta.app.entity.Miembrosgrupo;

@Service
public class MiembrosGrupoService implements IMiembrosGrupoService {
	
	@Autowired
	IMiembrosGrupoDao dao;

	@Override
	public List<Miembrosgrupo> ListarMiembros() {
		// TODO Auto-generated method stub
		return dao.ListarMiembros();
	}

	@Override
	public Miembrosgrupo buscarPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarMiembros(Miembrosgrupo Miembro) {
		// TODO Auto-generated method stub
		return dao.registrarMiembros(Miembro);
	}

	@Override
	public boolean borrarMiembro(String id) {
		// TODO Auto-generated method stub
		return dao.borrarMiembro(id);
	}

	@Override
	public boolean actualizarMiembro(Miembrosgrupo Miembro) {
		// TODO Auto-generated method stub
		return dao.actualizarMiembro(Miembro);
	}

}
