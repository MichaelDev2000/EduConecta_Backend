package com.educonecta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonecta.app.dao.IUsuarioDao;
import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.dto.UsuarioDetallesDTO;
import com.educonecta.app.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioDao dao;

	@Override
	public List<Usuario> ListarTodosUsuarios() {
		return dao.ListarUsuarios();
	}

	@Override
	public Usuario buscarUsuarioPorId(String id) {
		return dao.buscarPorId(id);
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {

		return dao.registrarUsuario(usuario);
	}

	@Override
	public boolean borrarUsuarioId(String id) {
		return dao.borrarUsuario(id);
	}

	@Override
	public boolean actualizarUsuario(String UsuarioId, String Nombres, String Apellidos, String Biografia) {
		return dao.actualizarUsuario(UsuarioId, Nombres, Apellidos, Biografia);
	}

	@Override
	public Usuario obtenerPorCorreo(String correo) {
		Usuario usuario = dao.buscarPorCorreo(correo);

		if (usuario == null) {
	        return null;  
	    }
	    return usuario;

	}

	@Override
	public boolean actualizarContrasena(String UsuarioId, String ContrasenaNew, String ContrasenaOld) {
		// TODO Auto-generated method stub
		return dao.actualizarContrasena(UsuarioId, ContrasenaNew, ContrasenaOld);
	}

	@Override
	public UsuarioDetallesDTO detallesUsuario(String usuarioId) {
		// TODO Auto-generated method stub
		return dao.detallesUsuario(usuarioId);
	}

	@Override
	public Usuario findOrCreateUser(String email, String name, String picture) {

		return dao.findOrCreateUser(email, name, picture);
	}

	@Override
	public String generateJwtToken(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.generateJwtToken(usuario);
	}

	@Override
	public UsuarioDTO buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return dao.obtenerPorCorreo(correo);
	}

}
