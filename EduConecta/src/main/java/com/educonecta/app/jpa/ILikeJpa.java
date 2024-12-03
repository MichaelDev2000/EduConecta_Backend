package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Like;

public interface ILikeJpa extends JpaRepository<Like, String>{

}
