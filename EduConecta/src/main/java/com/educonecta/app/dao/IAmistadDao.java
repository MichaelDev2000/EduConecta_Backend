package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.entity.Amistad;
import com.educonecta.app.entity.Usuario;

@Repository
public interface IAmistadDao {
	List<Amistad> ListarAmistades();
	List<Usuario>listarAmigosPorUsuarioId(String usuarioId);
	Amistad buscarPorId(String id);
	boolean registrarAmistad(Amistad amistad);
	boolean borrarAmistadById(String id);
	boolean actualizarAmistad(Amistad amistad);
}
