package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Temaacademico;

public interface ITemaAcademicoService {
	
	List<Temaacademico> ListarTodosTemas();
	Temaacademico buscarTemaPorId(String id);
	boolean registrarTema(Temaacademico tema);
	boolean borrarTemaId(String id);
	boolean actualizarTema(Temaacademico tema);
}
