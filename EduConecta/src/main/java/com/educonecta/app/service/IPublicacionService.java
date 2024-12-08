package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.entity.Publicacion;

public interface IPublicacionService {
	List<Publicacion> ListarTodosPost();
	List<PublicacionDTO> ListarPostOrdenados();
	Publicacion buscarPublicacionPorId(String id);
	boolean registrarPublicacion(Publicacion publicacion);
	boolean borrarPublicacionId(String id);
	boolean actualizarPublicacion(Publicacion publicacion);
}
