package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Rol;
import com.educonecta.app.jpa.IRolesJpa;

@Repository
public class RolDao implements IRolesDao {

	@Autowired
	IRolesJpa jpa;
	
	@Override
	public List<Rol> ListarRoles() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Rol buscarPorId(String id) {
		// TODO Auto-generated method stub
		
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarRol(Rol rol) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		rol.setRolId(uuid.toString());
		if(!jpa.save(rol).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarRolById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarRol(Rol rol) {
		// TODO Auto-generated method stub
		Rol rolEdit = jpa.findById(rol.getRol()).get();
		rolEdit.setRol(rol.getRol());
		if(!jpa.save(rolEdit).equals(null)) return true;
		return false;
	}
	
}
