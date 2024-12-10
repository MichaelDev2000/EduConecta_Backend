package com.educonecta.app.service;

import java.util.List;

import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.dto.UsuarioDetallesDTO;
import com.educonecta.app.entity.Usuario;

public interface IUsuarioService {
	List<Usuario> ListarTodosUsuarios();
	Usuario buscarUsuarioPorId(String id);
	UsuarioDTO obtenerPorCorreo(String correo);
	UsuarioDetallesDTO detallesUsuario(String usuarioId);
	boolean registrarUsuario(Usuario usuario);
	boolean borrarUsuarioId(String id);
	boolean actualizarContrasena(String UsuarioId, String ContrasenaNew, String ContrasenaOld);
	boolean actualizarUsuario(String UsuarioId, String Nombres, String Apellidos, String Biografia);
}
