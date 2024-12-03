package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Notificacion;

public interface INotificacionJpa extends JpaRepository<Notificacion, String>{

}
