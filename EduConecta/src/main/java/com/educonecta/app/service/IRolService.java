package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Rol;



public interface IRolService {
	List<Rol> ListarTodosRoles();
	Rol buscarRolPorId(String id);
	boolean registrarRol(Rol rol);
	boolean borrarRolId(String id);
	boolean actualizarRol(Rol rol);
}
