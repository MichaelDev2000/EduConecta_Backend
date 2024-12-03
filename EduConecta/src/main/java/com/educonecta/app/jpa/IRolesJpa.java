package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Rol;

public interface IRolesJpa extends JpaRepository<Rol, String> {

}
