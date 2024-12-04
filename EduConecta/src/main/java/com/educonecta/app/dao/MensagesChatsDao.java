package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Mensageschat;
import com.educonecta.app.jpa.IMensagesChatJpa;

@Repository
public class MensagesChatsDao implements IMensagesChatsDao {
	
	@Autowired
	IMensagesChatJpa jpa;

	@Override
	public List<Mensageschat> ListarMensages() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Mensageschat buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarMensage(Mensageschat mensages) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		mensages.setChatId(uuid.toString());
		if(!jpa.save(mensages).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarMensage(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarMensage(Mensageschat mensages) {
		// TODO Auto-generated method stub
		Mensageschat mensageEdit = jpa.findById(mensages.getChatId()).get();
		mensageEdit.setChatId(mensages.getChatId());
		if(!jpa.save(mensageEdit).equals(null)) return true;
		return false;
	}

}
