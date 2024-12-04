package com.educonecta.app.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Chat;
import com.educonecta.app.jpa.IChatJpa;

@Repository
public class ChatDao implements IChatDao {
	
	@Autowired
	IChatJpa jpa;

	@Override
	public List<Chat> ListarChats() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Chat buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registarChat(Chat chat) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		chat.setChatId(uuid.toString());
		if(!jpa.save(chat).equals(null)) return true;
		return false;
	}

	@Override
	public boolean borrarChatById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarChat(Chat chat) {
		// TODO Auto-generated method stub
		Chat chatEdit = jpa.findById(chat.getChatId()).get();
		chatEdit.setChatId(chat.getChatId());;
		if(!jpa.save(chatEdit).equals(null)) return true;
		return false;
	}

}
