package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IRolesDao;
import com.educonecta.app.entity.Rol;

@Service
public class RolService implements IRolService{
	
	@Autowired
	IRolesDao dao;

	@Override
	public List<Rol> ListarTodosRoles() {
		// TODO Auto-generated method stub
		return dao.ListarRoles();
	}

	@Override
	public Rol buscarRolPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarRol(Rol rol) {
		// TODO Auto-generated method stub
		return dao.registrarRol(rol);
	}

	@Override
	public boolean borrarRolId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarRolById(id);
	}

	@Override
	public boolean actualizarRol(Rol rol) {
		// TODO Auto-generated method stub
		return dao.actualizarRol(rol);
	}

}
