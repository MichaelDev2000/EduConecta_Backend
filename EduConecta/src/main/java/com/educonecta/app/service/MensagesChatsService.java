package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IMensagesChatsDao;
import com.educonecta.app.entity.Mensageschat;

@Service
public class MensagesChatsService implements IMensagesChatsService{
	
	@Autowired
	IMensagesChatsDao dao;

	@Override
	public List<Mensageschat> ListarTodosMsg() {
		// TODO Auto-generated method stub
		return dao.ListarMensages();
	}

	@Override
	public Mensageschat buscarMensajePorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarMensage(Mensageschat mensage) {
		// TODO Auto-generated method stub
		return dao.registrarMensage(mensage);
	}

	@Override
	public boolean borrarMensageId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarMensage(id);
	}

	@Override
	public boolean actualizarMensage(Mensageschat mensage) {
		// TODO Auto-generated method stub
		return dao.actualizarMensage(mensage);
	}

	
}
