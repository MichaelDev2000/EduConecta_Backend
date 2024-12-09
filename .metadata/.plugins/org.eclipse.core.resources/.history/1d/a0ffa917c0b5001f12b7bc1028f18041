package com.educonecta.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.entity.Publicacion;



public interface IPublicacionesDao {

	List<Publicacion> ListarPublicaciones();
	List<PublicacionDTO> ListarPublicacionesOrdenadas();
	Publicacion buscarPorId(String id);
	boolean registrarPublicacion(Publicacion publicacion);
	boolean borrarPublicacionById(String id);
	boolean actualizarPublicacion(Publicacion publicacion);
}
