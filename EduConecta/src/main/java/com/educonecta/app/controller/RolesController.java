package com.educonecta.app.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.educonecta.app.entity.Rol;
import com.educonecta.app.service.IRolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Roles", description = "Controlador para la gestion de roles")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "ApiRoles")
public class RolesController {

	@Autowired
	IRolService service;

	@Operation(summary = "Este endpoint permite crear o registrar un rol.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarRol(@RequestBody Rol rol) {
		if (service.registrarRol(rol)) {
			return new ResponseEntity<String>("El Rol ha sido guardado satisfactoriamente :)", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el ROl", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite listar todos los roles y su usuario asignado")
	@GetMapping(value = "ListaRoles")
	public ResponseEntity<List<Rol>> listarRoles() {
		List<Rol> lista = service.ListarTodosRoles();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Rol>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar un Rol por su Nombre")
	@GetMapping(value = "Rol-id")
	public ResponseEntity<?> rolById(@RequestParam String id) {
		Rol rolFind = service.buscarRolPorId(id);
		if(rolFind != null) {
			return new ResponseEntity<Rol>(rolFind, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al obtener rol con id "+id+".", HttpStatus.CONFLICT);
	}
}
