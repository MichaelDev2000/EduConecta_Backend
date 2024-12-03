package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Miembrosgrupo;

public interface IMiembrosGrupoService {

	List<Miembrosgrupo> ListarMiembros();

	Miembrosgrupo buscarPorId(String id);

	boolean registrarMiembros(Miembrosgrupo Miembro);

	boolean borrarMiembro(String id);

	boolean actualizarMiembro(Miembrosgrupo Miembro);
}
