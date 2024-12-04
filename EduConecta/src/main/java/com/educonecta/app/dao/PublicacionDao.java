package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Publicacion;
import com.educonecta.app.jpa.IPublicacionJpa;

@Repository
public class PublicacionDao implements IPublicacionesDao {

	@Autowired
	IPublicacionJpa jpa;
	
	@Override
	public List<Publicacion> ListarPublicaciones(){
		return jpa.findAll();
	}

	@Override
	public Publicacion buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		publicacion.setPostId(uuid.toString());
		if(!jpa.save(publicacion).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarPublicacionById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		Publicacion publicacionEdit = jpa.findById(publicacion.getPostId()).get();
		publicacionEdit.setPostId(publicacion.getPostId());
		if(!jpa.save(publicacionEdit).equals(null)) return true;
		return false;
	}
}
