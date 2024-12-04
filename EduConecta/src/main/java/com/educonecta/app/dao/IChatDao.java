package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Chat;

@Repository
public interface IChatDao {
	List<Chat> ListarChats();
	Chat buscarPorId(String id);
	boolean registarChat(Chat chat);
	boolean borrarChatById(String id);
	boolean actualizarChat(Chat chat);
}
