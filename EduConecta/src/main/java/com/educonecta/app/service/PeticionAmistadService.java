package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IPeticionAmistadDao;
import com.educonecta.app.entity.Peticionesamistad;

@Service
public class PeticionAmistadService implements IPeticionAmistadService {

	@Autowired
	IPeticionAmistadDao dao;
	
	@Override
	public List<Peticionesamistad> listarPeticiones() {
		// TODO Auto-generated method stub
		return dao.listarPeticiones();
	}

	@Override
	public Peticionesamistad buscarPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarPeticion(Peticionesamistad peticion) {
		// TODO Auto-generated method stub
		return dao.registrarPeticion(peticion);
	}

	@Override
	public boolean borrarPeticion(String id) {
		// TODO Auto-generated method stub
		return dao.borrarPeticion(id);
	}

	@Override
	public boolean actualizarPeticion(Peticionesamistad peticion) {
		// TODO Auto-generated method stub
		return dao.actualizarPeticion(peticion);
	}

}
