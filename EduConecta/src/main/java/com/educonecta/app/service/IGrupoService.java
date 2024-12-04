package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Grupo;


public interface IGrupoService {
	List<Grupo> ListarTodosGrupos();
	Grupo buscarGrupoPorId(String id);
	boolean registrarGrupo(Grupo grupo);
	boolean borrarGrupoId(String id);
	boolean actualizarGrupo(Grupo grupo);
}
