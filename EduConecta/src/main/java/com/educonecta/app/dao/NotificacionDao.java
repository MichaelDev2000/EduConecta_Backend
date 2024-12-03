package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Notificacion;
import com.educonecta.app.jpa.INotificacionJpa;

@Repository
public class NotificacionDao implements INotificacionDao {

	@Autowired
	INotificacionJpa jpa;
	
	@Override
	public List<Notificacion> listarNotificaciones() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Notificacion buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarNotificacion(Notificacion notificacion) {
		UUID uuid = UUID.randomUUID();
		notificacion.setNotificacionId(uuid.toString());
		if(!jpa.save(notificacion).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarNotificacion(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return false;
	}

	@Override
	public boolean actualizarNotificacion(Notificacion notificacion) {
		Notificacion notificacionEdit = jpa.findById(notificacion.getNotificacionId()).get();
		notificacionEdit.setNotiTipo(notificacion.getNotiTipo());
		notificacionEdit.setNotiVista(notificacion.getNotiTipo());
		if(!jpa.save(notificacionEdit).equals(null)) return true;
		return false;
	}

}
