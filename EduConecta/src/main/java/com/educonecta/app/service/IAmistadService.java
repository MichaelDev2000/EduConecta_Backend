package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Amistad;
import com.educonecta.app.entity.Usuario;

public interface IAmistadService {
	List<Amistad> ListarTodasAmistades();
	List<Usuario>listarAmigosPorUsuarioId(String usuarioId);
	Amistad buscarAmistadPorId(String id);
	boolean registrarAmistad(Amistad amistad);
	boolean borrarAmistadId(String id);
	boolean acutalizarAmistad(Amistad amistad);
}
