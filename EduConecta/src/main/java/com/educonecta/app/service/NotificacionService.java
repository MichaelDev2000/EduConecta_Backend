package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.INotificacionDao;
import com.educonecta.app.entity.Notificacion;

@Service
public class NotificacionService implements INotificacionService {

	@Autowired
	INotificacionDao dao;
	
	@Override
	public List<Notificacion> listarNotificaciones() {
		// TODO Auto-generated method stub
		return dao.listarNotificaciones();
	}

	@Override
	public Notificacion buscarPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarNotificacion(Notificacion notificacion) {
		// TODO Auto-generated method stub
		return dao.registrarNotificacion(notificacion);
	}

	@Override
	public boolean borrarNotificacion(String id) {
		// TODO Auto-generated method stub
		return dao.borrarNotificacion(id);
	}

	@Override
	public boolean actualizarNotificacion(Notificacion notificacion) {
		// TODO Auto-generated method stub
		return dao.actualizarNotificacion(notificacion);
	}

}
