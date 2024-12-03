package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Chat;

public interface IChatJpa extends JpaRepository<Chat, String>{

}
