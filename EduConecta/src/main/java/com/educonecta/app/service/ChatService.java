package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IChatDao;
import com.educonecta.app.entity.Chat;

@Service
public class ChatService implements IChatService{
	
	@Autowired
	IChatDao dao;

	@Override
	public List<Chat> ListarTodosChats() {
		// TODO Auto-generated method stub
		return dao.ListarChats();
	}

	@Override
	public Chat buscarChatPorId(String id) {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarChat(Chat chat) {
		// TODO Auto-generated method stub
		return dao.registarChat(chat);
	}

	@Override
	public boolean borrarChatId(String id) {
		// TODO Auto-generated method stub
		return dao.borrarChatById(id);
	}

	@Override
	public boolean actualizarChat(Chat chat) {
		// TODO Auto-generated method stub
		return dao.actualizarChat(chat);
	}

}
