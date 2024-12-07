package com.educonecta.app.dao;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.educonecta.app.entity.Usuario;
import com.educonecta.app.jpa.IUsuarioJpa;
import com.educonecta.app.utils.Tools;

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
		String contraseñaHasheada = passwordEncoder.encode(usuario.getUsuContrasena());
		usuario.setUsuContrasena(contraseñaHasheada);
		usuario.setUsuImgperfil(randomAvatar);
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
	public boolean actualizarUsuario(Usuario usuario) {
		Usuario usuarioEditar = jpa.findById(usuario.getUsuarioId().toString()).get();
		usuarioEditar.setUsuNombres(usuario.getUsuNombres());
		usuarioEditar.setUsuApellidos(usuario.getUsuApellidos());
		usuarioEditar.setUsuBiografia(usuario.getUsuBiografia());
		usuarioEditar.setUsuImgperfil(usuario.getUsuImgperfil());
		usuarioEditar.setUsuCorreo(usuario.getUsuCorreo());
		usuarioEditar.setUsuContrasena(passwordEncoder.encode(usuario.getUsuContrasena()));
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
			}, correo); // Nota cómo el argumento se pasa directamente aquí
		} catch (Exception e) {
			// Manejar el caso cuando no se encuentra el usuario
			System.err.println("Usuario no encontrado: " + e.getMessage());
			return null;
		}
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

}
