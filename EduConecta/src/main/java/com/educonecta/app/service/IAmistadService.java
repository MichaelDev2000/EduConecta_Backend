package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Amistad;

public interface IAmistadService {
	List<Amistad> ListarTodasAmistades();
	Amistad buscarAmistadPorId(String id);
	boolean registrarAmistad(Amistad amistad);
	boolean borrarAmistadId(String id);
	boolean acutalizarAmistad(Amistad amistad);
}
