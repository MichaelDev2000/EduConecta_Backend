package com.educonecta.app.dao;

import java.util.List;

import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.dto.UsuarioDetallesDTO;
import com.educonecta.app.entity.Usuario;

public interface IUsuarioDao {
	List<Usuario> ListarUsuarios();
	Usuario buscarPorId(String id);
	Usuario findOrCreateUser(String email, String name, String picture);
	public String generateJwtToken(Usuario usuario);
	Usuario buscarPorCorreo(String correo);
	UsuarioDTO obtenerPorCorreo(String correo);
	UsuarioDetallesDTO detallesUsuario(String usuarioId);
	boolean registrarUsuario(Usuario usuario);
	boolean borrarUsuario(String id);
	boolean actualizarContrasena(String UsuarioId, String ContrasenaNew, String ContrasenaOld);
	boolean actualizarUsuario(String UsuarioId, String Nombres, String Apellidos, String Biografia);
}
