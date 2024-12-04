package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Grupo;
import com.educonecta.app.jpa.IGrupoJpa;

@Repository
public class GrupoDao implements IGrupoDao{
	
	@Autowired
	IGrupoJpa jpa;

	@Override
	public List<Grupo> ListarGrupos() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Grupo buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		grupo.setGrupoId(uuid.toString());
		if(!jpa.save(grupo).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarGrupoById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		Grupo grupoEdit = jpa.findById(grupo.getGrupoId()).get();
		grupoEdit.setGrupoId(grupo.getGrupoId());
		if(!jpa.save(grupoEdit).equals(null)) return true;
		return false;
	}

	
}
