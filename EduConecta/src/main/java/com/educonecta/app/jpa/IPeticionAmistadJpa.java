package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Peticionesamistad;

public interface IPeticionAmistadJpa extends JpaRepository<Peticionesamistad, String> {

}
