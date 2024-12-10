package com.educonecta.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Amistad;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.jpa.IAmistadJpa;

@Repository
public class AmistadDao implements IAmistadDao {

	@Autowired
	IAmistadJpa jpa;

	@Override
	public List<Amistad> ListarAmistades() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Amistad buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarAmistad(Amistad amistad) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		amistad.setAmistadId(uuid.toString());
		if (!jpa.save(amistad).equals(null))
			return true;
		return false;
	}

	@Override
	public boolean borrarAmistadById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarAmistad(Amistad amistad) {
		// TODO Auto-generated method stub
		Amistad amistadEdit = jpa.findById(amistad.getAmistadId()).get();
		amistadEdit.setAmistadId(amistad.getAmistadId());
		if (!jpa.save(amistadEdit).equals(null))
			return true;
		return false;
	}

	@Override
	public List<Usuario> listarAmigosPorUsuarioId(String usuarioId) {
	    // Consulta todas las amistades en las que el usuario está involucrado
	    List<Amistad> amistades = jpa.findByUsuario1_UsuarioIdOrUsuario2_UsuarioId(usuarioId, usuarioId);
	    
	    // Crear una lista para almacenar los amigos (usuarios que no sean el usuarioId)
	    List<Usuario> amigos = new ArrayList<>();
	    
	    // Iterar sobre las amistades encontradas
	    for (Amistad amistad : amistades) {
	        // Si el usuarioId es el usuario1, agregar el usuario2 como amigo
	        if (amistad.getUsuario1().getUsuarioId().equals(usuarioId)) {
	            amigos.add(amistad.getUsuario2());
	        } 
	        // Si el usuarioId es el usuario2, agregar el usuario1 como amigo
	        else if (amistad.getUsuario2().getUsuarioId().equals(usuarioId)) {
	            amigos.add(amistad.getUsuario1());
	        }
	    }

	    // Devolver la lista de amigos (usuarios que no son el usuarioId)
	    return amigos;
	}


}
