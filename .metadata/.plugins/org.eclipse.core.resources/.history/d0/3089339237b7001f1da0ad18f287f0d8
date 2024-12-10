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
		
		return dao.registrarUsuario(usuario) ;
	}

	@Override
	public boolean borrarUsuarioId(String id) {
		return dao.borrarUsuario(id);
	}

	@Override
	public boolean actualizarUsuario(String UsuarioId,String Nombres, String Apellidos, String Biografia) {
		return dao.actualizarUsuario(UsuarioId,Nombres,Apellidos,Biografia);
	}
	
	public UsuarioDTO obtenerPorCorreo(String correo) {
        Usuario usuario = dao.buscarPorCorreo(correo);
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuarioId(usuario.getUsuarioId());
        usuarioDTO.setUsuApellidos(usuario.getUsuApellidos());
        usuarioDTO.setUsuBiografia(usuario.getUsuBiografia());
        usuarioDTO.setUsuCorreo(usuario.getUsuCorreo());
        usuarioDTO.setUsuImgperfil(usuario.getUsuImgperfil());
        usuarioDTO.setUsuNombres(usuario.getUsuNombres());
        usuarioDTO.setUsuStatus(usuario.getUsuStatus());

        return usuarioDTO;
        
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

}
