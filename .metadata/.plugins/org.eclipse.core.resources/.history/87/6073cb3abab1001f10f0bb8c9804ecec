package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Temasinteresusuario;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.service.ITemaInteresUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API de Temas de interes del usuario", description="Controlador para gestionar los temas de interes del usuario")
@RestController
@RequestMapping(value="TemasInteres")
public class TemaInteresUsuarioController {
	
	@Autowired
	ITemaInteresUsuarioService service;
	
	@Operation(summary="Este endpoint permite crear o registrar un tema de interes del usuario registrado.")
	@PostMapping(value="registrarTemaInteres",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarTemaUsuario(@RequestBody Temasinteresusuario tema) {
		if(service.registrarTema(tema)) {
			return new ResponseEntity<String>("El tema de interes ha sido guardado satisfactoriamente papus :)",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error interno al guardar el tema de interes.",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite listar todos los temas de interes que hay guardados.")
	@GetMapping(value="AllTemasInteres")
	public ResponseEntity<?> listarTemasInteres(){
		List<Temasinteresusuario> list = service.ListarTodosTemasDeInteres();
		//1.Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		System.out.println(list);
		//2. armamos la respuesta de tipo ResponseEntity
		return new ResponseEntity<List<Temasinteresusuario>>(list, headers,HttpStatus.ACCEPTED);
	}
	

}
