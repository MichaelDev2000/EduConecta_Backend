package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IPublicacionesDao;
import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.entity.Publicacion;

@Service
public class PublicacionService implements IPublicacionService{

	@Autowired
	IPublicacionesDao dao;

	@Override
	public List<Publicacion> ListarTodosPost() {
		// TODO Auto-generated method stub
		return dao.ListarPublicaciones();
	}

	@Override
	public Publicacion buscarPublicacionPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return dao.registrarPublicacion(publicacion);
	}

	@Override
	public boolean borrarPublicacionId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarPublicacionById(id);
	}

	@Override
	public boolean actualizarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return dao.actualizarPublicacion(publicacion);
	}

	@Override
	public List<PublicacionDTO> ListarPostOrdenados() {
		// TODO Auto-generated method stub
		return dao.ListarPublicacionesOrdenadas();
	}
	
}
