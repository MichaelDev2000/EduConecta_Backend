package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.entity.Mensageschat;

public interface IMensagesChatsDao {
	List<Mensageschat> ListarMensages();
	Mensageschat buscarPorId(String id);
	boolean registrarMensage(Mensageschat mensages);
	boolean borrarMensage(String id);
	boolean actualizarMensage(Mensageschat mensages);

}
