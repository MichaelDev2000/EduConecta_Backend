package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.entity.Chat;

public interface IChatService {
	List<Chat> ListarTodosChats();
	Chat buscarChatPorId(String id);
	boolean registrarChat(Chat chat);
	boolean borrarChatId(String id);
	boolean actualizarChat(Chat chat);

}
