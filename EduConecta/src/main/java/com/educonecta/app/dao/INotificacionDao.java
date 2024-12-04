package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.entity.Notificacion;



public interface INotificacionDao {
	List<Notificacion> listarNotificaciones();
	Notificacion buscarPorId(String id);
	boolean registrarNotificacion(Notificacion notificacion);
	boolean borrarNotificacion(String id);
	boolean actualizarNotificacion(Notificacion notificacion);
}
