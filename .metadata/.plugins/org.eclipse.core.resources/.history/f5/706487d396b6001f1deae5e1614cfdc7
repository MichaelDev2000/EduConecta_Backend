package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IAmistadDao;
import com.educonecta.app.entity.Amistad;

@Service
public class AmistadService implements IAmistadService{
	
	@Autowired
	IAmistadDao dao;

	@Override
	public List<Amistad> ListarTodasAmistades() {
		// TODO Auto-generated method stub
		return dao.ListarAmistades();
	}

	@Override
	public Amistad buscarAmistadPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarAmistad(Amistad amistad) {
		// TODO Auto-generated method stub
		return dao.registrarAmistad(amistad);
	}

	@Override
	public boolean borrarAmistadId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarAmistadById(id);
	}

	@Override
	public boolean acutalizarAmistad(Amistad amistad) {
		// TODO Auto-generated method stub
		return dao.actualizarAmistad(amistad);
	}

}
