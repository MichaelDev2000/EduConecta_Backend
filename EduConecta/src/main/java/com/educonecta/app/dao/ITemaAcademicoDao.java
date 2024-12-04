package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.entity.Temaacademico;


public interface ITemaAcademicoDao {
	List<Temaacademico> ListarTemas();
	Temaacademico buscarPorId(String id);
	boolean registrarTema(Temaacademico tema);

	boolean borrarTema(String id);

	boolean actualizarTema(Temaacademico tema);
}
