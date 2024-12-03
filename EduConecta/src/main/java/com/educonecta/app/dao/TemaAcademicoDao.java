package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Temaacademico;
import com.educonecta.app.jpa.ITemaAcademicoJpa;

@Repository
public class TemaAcademicoDao implements ITemaAcademicoDao {

	@Autowired
	ITemaAcademicoJpa jpa;
	
	@Override
	public List<Temaacademico> ListarTemas() {
		return jpa.findAll();
	}

	@Override
	public Temaacademico buscarPorId(String id) {
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarTema(Temaacademico tema) {
		UUID uuid = UUID.randomUUID();
		tema.setTemaId(uuid.toString());
		if(!jpa.save(tema).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarTema(String id) {
		jpa.deleteById(id);
		return false;
	}

	@Override
	public boolean actualizarTema(Temaacademico tema) {
		Temaacademico temaEdit = jpa.findById(tema.getTemaId()).get();
		temaEdit.setTemaNombre(tema.getTemaNombre());
		temaEdit.setTemaDescripcion(tema.getTemaDescripcion());
		if(!jpa.save(temaEdit).equals(null))return true;
		return false;
	}
	

}
