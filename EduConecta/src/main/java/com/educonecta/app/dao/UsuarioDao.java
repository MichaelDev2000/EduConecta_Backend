package com.educonecta.app.dao;

import static com.educonecta.app.utils.Tools.CLAVE;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import com.educonecta.app.dto.ComentarioDTO;
import com.educonecta.app.dto.GrupoDTO;
import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.dto.UsuarioDetallesDTO;
import com.educonecta.app.entity.Publicacion;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.jpa.IComentarioJpa;
import com.educonecta.app.jpa.ILikeJpa;
import com.educonecta.app.jpa.IPublicacionJpa;
import com.educonecta.app.jpa.IUsuarioJpa;
import com.educonecta.app.utils.JwtUtil;
import com.educonecta.app.utils.Tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Repository
public class UsuarioDao implements IUsuarioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	IUsuarioJpa jpa;

	@Autowired
	IPublicacionJpa jpaPubli;

	@Autowired
	ILikeJpa likeJpa;

	@Autowired
	IComentarioJpa comentJpa;

	@Override
	public List<Usuario> ListarUsuarios() {
		return jpa.findAll();
	}

	@Override
	public Usuario buscarPorId(String id) {
		return jpa.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public boolean registrarUsuario(Usuario usuario) {
		UUID uuidROl = UUID.randomUUID();
		Random random = new Random();
		int randomIndex = random.nextInt(Tools.avatares.length);
		String randomAvatar = Tools.avatares[randomIndex];

		jdbcTemplate.update("INSERT INTO roles (rol_id, rol, usu_correo) VALUES (?,?, ?)", uuidROl.toString(),
				"ROLE_USERS", usuario.getUsuCorreo());
		UUID uuid = UUID.randomUUID();
		if (usuario.getUsuContrasena() != null) {
			String contraseñaHasheada = passwordEncoder.encode(usuario.getUsuContrasena());
			usuario.setUsuContrasena(contraseñaHasheada);
		} else {
			usuario.setUsuContrasena(null);
		}
		if (usuario.getUsuImgperfil() == null) {
			usuario.setUsuImgperfil(randomAvatar);
		}

		usuario.setUsuarioId(uuid.toString());
		usuario.setUsuStatus(1);
		if (!jpa.save(usuario).equals(null))
			return true;
		return false;
	}

	@Override
	public boolean borrarUsuario(String id) {
		jpa.deleteById(id);
		return true;
	}

	@Override
	public boolean actualizarUsuario(String UsuarioId, String Nombres, String Apellidos, String Biografia) {
		Usuario usuarioEditar = jpa.findById(UsuarioId).get();
		usuarioEditar.setUsuNombres(Nombres);
		usuarioEditar.setUsuApellidos(Apellidos);
		usuarioEditar.setUsuBiografia(Biografia);
		if (!jpa.save(usuarioEditar).equals(null))
			return true;
		return false;
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		String sql = "SELECT * FROM usuarios WHERE usu_correo = ?";
		try {
			return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
				Usuario usuario = new Usuario();
				usuario.setUsuarioId(rs.getString("usuario_id"));
				usuario.setUsuCorreo(rs.getString("usu_correo"));
				usuario.setUsuContrasena(rs.getString("usu_contrasena"));
				usuario.setUsuNombres(rs.getString("usu_nombres"));
				usuario.setUsuApellidos(rs.getString("usu_apellidos"));
				usuario.setUsuBiografia(rs.getString("usu_biografia"));
				usuario.setUsuImgperfil(rs.getString("usu_imgperfil"));
				usuario.setUsuStatus(rs.getInt("usu_status"));
				return usuario;
			}, correo);
		} catch (Exception e) {
			System.err.println("Usuario no encontrado: " + e.getMessage());
			return null;
		}
	}

	@Override
	public UsuarioDTO obtenerPorCorreo(String correo) {
		Usuario usuario = jpa.findByUsuCorreo(correo);
		if (usuario != null) {
			return new UsuarioDTO(usuario); // Convierte el Usuario en UsuarioDTO
		}
		return null; // O lanza una excepción si no se encuentra el usuario
	}

	@Override
	public boolean actualizarContrasena(String UsuarioId, String ContrasenaNew, String ContrasenaOld) {
		Usuario usuarioEditPass = jpa.findById(UsuarioId).get();
		if (passwordEncoder.matches(ContrasenaOld, usuarioEditPass.getUsuContrasena())) {
			String contraseñaNewHash = passwordEncoder.encode(ContrasenaNew);
			usuarioEditPass.setUsuContrasena(contraseñaNewHash);
			if (!jpa.save(usuarioEditPass).equals(null))
				return true;
		} else {
			return false;
		}
		return false;
	}

	@Override
	public UsuarioDetallesDTO detallesUsuario(String usuarioId) {

		Usuario usuario = jpa.findById(usuarioId).orElse(null);
		if (usuario == null) {
			return null;
		}

		List<Publicacion> publicaciones = jpaPubli.findByUsuario_UsuarioId(usuarioId);

		List<PublicacionDTO> publicacionesDTO = publicaciones.stream().map(publicacion -> {
			PublicacionDTO dto = new PublicacionDTO();
			dto.setPostId(publicacion.getPostId());
			dto.setContenido(publicacion.getPostContenido());
			dto.setImagen(publicacion.getPostImgpost());
			dto.setCreadoEn(publicacion.getCreatedAt().toString());
			dto.setTemaNombre(publicacion.getTemasacademico().getTemaNombre());
			dto.setUsuarioID(publicacion.getUsuario().getUsuarioId());
			dto.setUsuarioNombre(publicacion.getUsuario().getUsuNombres());
			dto.setUsuarioImagen(publicacion.getUsuario().getUsuImgperfil());
			Long numeroLikes = likeJpa.countByPublicacionPostId(publicacion.getPostId());
			dto.setNumeroLikes(numeroLikes);

			List<ComentarioDTO> comentarios = comentJpa.findByPublicacion_PostId(publicacion.getPostId()).stream()
					.map(comentario -> {
						ComentarioDTO comentarioDto = new ComentarioDTO();
						comentarioDto.setComentarioId(comentario.getComentarioId());
						comentarioDto.setContenido(comentario.getComentContenido());
						comentarioDto.setCreadoEn(comentario.getCreatedAt().toString());

						Usuario comentarioUsuario = comentario.getUsuario();
						if (comentarioUsuario != null) {
							comentarioDto.setUsuarioID(comentarioUsuario.getUsuarioId());
							comentarioDto.setUsuarioNombre(
									comentarioUsuario.getUsuNombres() + " " + comentarioUsuario.getUsuApellidos());
							comentarioDto.setUsuarioImagen(comentarioUsuario.getUsuImgperfil());
						}

						return comentarioDto;
					}).collect(Collectors.toList());

			dto.setComentarios(comentarios);
			return dto;
		}).collect(Collectors.toList());

		UsuarioDetallesDTO usuarioDetallesDTO = new UsuarioDetallesDTO();
		usuarioDetallesDTO.setUsuarioId(usuario.getUsuarioId());
		usuarioDetallesDTO.setUsuNombres(usuario.getUsuNombres());
		usuarioDetallesDTO.setUsuImgperfil(usuario.getUsuImgperfil());
		usuarioDetallesDTO.setUsuApellidos(usuario.getUsuApellidos());
		usuarioDetallesDTO.setUsuBiografia(usuario.getUsuBiografia());
		usuarioDetallesDTO.setUsuCorreo(usuario.getUsuCorreo());
		usuarioDetallesDTO.setPublicaciones(publicacionesDTO);

		return usuarioDetallesDTO;
	}

	@Override
	public Usuario findOrCreateUser(String email, String name, String picture) {
		Usuario existingUser = jpa.findByUsuCorreo(email);

		if (existingUser != null) {
			return existingUser;
		} else {

			Usuario newUser = new Usuario();
			newUser.setUsuarioId(UUID.randomUUID().toString());
			newUser.setUsuCorreo(email);
			newUser.setUsuNombres(name.split(" ")[0]);
			newUser.setUsuApellidos(name.split(" ")[1]);
			newUser.setUsuImgperfil(picture);
			newUser.setUsuStatus(1);

			return jpa.save(newUser);
		}
	}

	public String generateJwtToken(Usuario usuario) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(usuario.getUsuCorreo(), null,
				List.of(new SimpleGrantedAuthority("ROLE_USERS")));
		return JwtUtil.generateToken(authentication);
	}
}
