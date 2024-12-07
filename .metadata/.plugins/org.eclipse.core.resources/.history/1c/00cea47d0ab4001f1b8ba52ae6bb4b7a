package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Temasinteresusuario;
import com.educonecta.app.jpa.ITemaInteresUsuarioJpa;

@Repository
public class TemaInteresUsuarioDao implements ITemaInteresUsuarioDao{
	
	@Autowired
	ITemaInteresUsuarioJpa jpa;

	@Override
	public List<Temasinteresusuario> ListarTemas() {
		return jpa.findAll();
	}

	@Override
	public Temasinteresusuario buscarPorId(String id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean registrarTema(Temasinteresusuario tema) {
		UUID uuid = UUID.randomUUID();
		tema.setTemasinteresusuarioId(uuid.toString());
		if(!jpa.save(tema).equals(null))return true; 
		return false;
	}

	@Override
	public boolean borrarTema(String id) {
		jpa.deleteById(id);
		return true;
	}


}
