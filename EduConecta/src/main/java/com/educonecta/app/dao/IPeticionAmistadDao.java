package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.entity.Peticionesamistad;

public interface IPeticionAmistadDao {
	List<Peticionesamistad> listarPeticiones();
	Peticionesamistad buscarPorId(String id);
	boolean registrarPeticion(Peticionesamistad peticion);
	boolean borrarPeticion(String id);
	boolean actualizarPeticion(Peticionesamistad peticion);
}
