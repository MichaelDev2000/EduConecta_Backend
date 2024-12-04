package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Grupo;


@Repository
public interface IGrupoDao {
	List<Grupo> ListarGrupos();
	Grupo buscarPorId(String id);
	boolean registrarGrupo(Grupo grupo);
	boolean borrarGrupoById(String id);
	boolean actualizarGrupo(Grupo grupo);
	
}