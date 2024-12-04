package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Mensageschat;

public interface IMensagesChatsService {
	List<Mensageschat> ListarTodosMsg();
	Mensageschat buscarMensajePorId(String id);
	boolean registrarMensage(Mensageschat mensage);
	boolean borrarMensageId(String id);
	boolean actualizarMensage(Mensageschat mensage);
}
