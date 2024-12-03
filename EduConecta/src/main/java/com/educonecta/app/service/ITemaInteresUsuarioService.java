package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Temasinteresusuario;

public interface ITemaInteresUsuarioService {
	List<Temasinteresusuario> ListarTodosTemasDeInteres();

	Temasinteresusuario buscarTemaPorId(String id);

	boolean registrarTema(Temasinteresusuario tema);

	boolean borrarTemaId(String id);

}
