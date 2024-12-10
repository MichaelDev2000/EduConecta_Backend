package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Peticionesamistad;
import com.educonecta.app.jpa.IPeticionAmistadJpa;

@Repository
public class PeticionAmistadDao implements IPeticionAmistadDao {

	@Autowired
	IPeticionAmistadJpa jpa;
	
	@Override
	public List<Peticionesamistad> listarPeticiones() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Peticionesamistad buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarPeticion(Peticionesamistad peticion) {
		UUID uuid = UUID.randomUUID();
		peticion.setPeticionId(uuid.toString());
		peticion.setPeticionEstado("PENDIENTE");
		if(!jpa.save(peticion).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarPeticion(String id) {
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarPeticion(Peticionesamistad peticion) {
		Peticionesamistad peticionEdit = jpa.findById(peticion.getPeticionId()).get();
		peticionEdit.setPeticionEstado(peticion.getPeticionEstado());
		if(!jpa.save(peticionEdit).equals(null)) return true;
		return false;
	}

	@Override
	public List<Peticionesamistad> listarPeticionesPendientesRecibidas(String idUsuarioDestino) {
		// TODO Auto-generated method stub
		return  jpa.findByUsuario2_UsuarioIdAndPeticionEstado(idUsuarioDestino, "PENDIENTE");
	}

}
