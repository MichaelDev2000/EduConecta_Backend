package com.educonecta.app.dao;

import java.util.stream.Collectors;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.educonecta.app.dto.ComentarioDTO;
import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.entity.Comentario;
import com.educonecta.app.entity.Publicacion;
import com.educonecta.app.entity.Temaacademico;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.jpa.IComentarioJpa;
import com.educonecta.app.jpa.ILikeJpa;
import com.educonecta.app.jpa.IPublicacionJpa;

@Repository
public class PublicacionDao implements IPublicacionesDao {

	@Autowired
	IPublicacionJpa jpa;

	@Autowired
	ILikeJpa likeJpa;

	@Autowired
	IComentarioJpa comentJpa;

	@Override
	public List<Publicacion> ListarPublicaciones() {
		return jpa.findAll();
	}

	@Override
	public Publicacion buscarPorId(String id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).get();
	}

	@Override
	public boolean registrarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		publicacion.setPostId(uuid.toString());
		if (!jpa.save(publicacion).equals(null))
			return true;
		return false;
	}

	@Override
	public boolean borrarPublicacionById(String id) {
		// TODO Auto-generated method stub
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		Publicacion publicacionEdit = jpa.findById(publicacion.getPostId()).get();
		publicacionEdit.setPostId(publicacion.getPostId());
		if (!jpa.save(publicacionEdit).equals(null))
			return true;
		return false;
	}

	@Override
	public List<PublicacionDTO> ListarPublicacionesOrdenadas() {
		List<Publicacion> publicaciones = jpa.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

		return publicaciones.stream().map(publicacion -> {
			PublicacionDTO publicacionDto = new PublicacionDTO();

			publicacionDto.setPostId(publicacion.getPostId());
			publicacionDto.setContenido(publicacion.getPostContenido());
			publicacionDto.setImagen(publicacion.getPostImgpost());
			publicacionDto.setCreadoEn(publicacion.getCreatedAt().toString());

			Temaacademico tema = publicacion.getTemasacademico();
			if (tema != null) {
				publicacionDto.setTemaNombre(tema.getTemaNombre());
				publicacionDto.setTemaDescripcion(tema.getTemaDescripcion());
			}

			Usuario usuario = publicacion.getUsuario();
			if (usuario != null) {
				publicacionDto.setUsuarioID(usuario.getUsuarioId());
				publicacionDto.setUsuarioNombre(usuario.getUsuNombres() + " " + usuario.getUsuApellidos());
				publicacionDto.setUsuarioImagen(usuario.getUsuImgperfil());
			}

			Long numeroLikes = likeJpa.countByPublicacionPostId(publicacion.getPostId());
			publicacionDto.setNumeroLikes(numeroLikes);

			// Convertir los comentarios a ComentarioDTO
			List<ComentarioDTO> comentarios = comentJpa.findByPublicacion_PostId(publicacion.getPostId()).stream()
					.map(comentario -> {
						ComentarioDTO comentarioDto = new ComentarioDTO();
						comentarioDto.setComentarioId(comentario.getComentarioId());
						comentarioDto.setContenido(comentario.getComentContenido());
						comentarioDto.setCreadoEn(comentario.getCreatedAt().toString());



						// Obtener el usuario que realizó el comentario
						Usuario comentarioUsuario = comentario.getUsuario();
						if (comentarioUsuario != null) {
							comentarioDto.setUsuarioID(comentarioUsuario.getUsuarioId());
							comentarioDto.setUsuarioNombre(
									comentarioUsuario.getUsuNombres() + " " + comentarioUsuario.getUsuApellidos());
							comentarioDto.setUsuarioImagen(comentarioUsuario.getUsuImgperfil());
						}

						return comentarioDto;
					}).collect(Collectors.toList());

			publicacionDto.setComentarios(comentarios);

			return publicacionDto;
		}).collect(Collectors.toList());
	}

}
