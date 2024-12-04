package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.entity.Miembrosgrupo;


public interface IMiembrosGrupoDao {
	List<Miembrosgrupo> ListarMiembros();

	Miembrosgrupo buscarPorId(String id);

	boolean registrarMiembros(Miembrosgrupo Miembro);

	boolean borrarMiembro(String id);

	boolean actualizarMiembro(Miembrosgrupo Miembro);
}
