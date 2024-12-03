package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Rol;

@Repository
public interface IRolesDao {
	List<Rol> ListarRoles();
	Rol buscarPorId(String id);
	boolean registrarRol(Rol rol);
	boolean borrarRolById(String id);
	boolean actualizarRol(Rol rol);
	
}
