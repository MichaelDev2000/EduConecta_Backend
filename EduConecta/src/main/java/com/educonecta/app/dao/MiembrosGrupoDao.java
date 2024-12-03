package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Miembrosgrupo;
import com.educonecta.app.jpa.IMiembrosGrupoJpa;

@Repository
public class MiembrosGrupoDao implements IMiembrosGrupoDao {

	@Autowired
	IMiembrosGrupoJpa jpa;
	

	@Override
	public List<Miembrosgrupo> ListarMiembros() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public boolean registrarMiembros(Miembrosgrupo Miembro) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		Miembro.setMiembrogrupoId(uuid.toString());
		if(!jpa.save(Miembro).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarMiembro(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarMiembro(Miembrosgrupo Miembro) {
		Miembrosgrupo miembrosEdit = jpa.findById(Miembro.getMiembrogrupoId()).get();
		miembrosEdit.setGrupo(Miembro.getGrupo());
		return false;
	}

	@Override
	public Miembrosgrupo buscarPorId(String id) {
		
		return jpa.findById(id).get();
	}

}
