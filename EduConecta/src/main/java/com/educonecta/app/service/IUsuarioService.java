package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.entity.Usuario;

public interface IUsuarioService {
	List<Usuario> ListarTodosUsuarios();
	Usuario buscarUsuarioPorId(String id);
	UsuarioDTO obtenerPorCorreo(String correo);
	boolean registrarUsuario(Usuario usuario);
	boolean borrarUsuarioId(String id);
	boolean actualizarUsuario(Usuario usuario);
	boolean actualizarContrasena(String UsuarioId, String ContrasenaNew, String ContrasenaOld);
}
