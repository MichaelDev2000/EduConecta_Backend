package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Peticionesamistad;

public interface IPeticionAmistadService {
	List<Peticionesamistad> listarPeticiones();
	List<Peticionesamistad>listarPeticionesPendientesRecibidas(String idUsuarioDestino);
	Peticionesamistad buscarPorId(String id);
	boolean registrarPeticion(Peticionesamistad peticion);
	boolean borrarPeticion(String id);
	boolean actualizarPeticion(Peticionesamistad peticion);
}
