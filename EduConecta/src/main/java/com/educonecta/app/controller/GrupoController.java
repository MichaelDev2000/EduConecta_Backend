package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Grupo;
import com.educonecta.app.service.IGrupoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Grupos", description = "Controlador para la gestion de grupos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "ApiGrupos")
public class GrupoController {

	@Autowired
	IGrupoService service;

	@Operation(summary = "Este endpoint permite crear o registrar un grupo.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarGrupo(@RequestBody Grupo grupo) {
		if (service.registrarGrupo(grupo)) {
			return new ResponseEntity<String>("El grupo ha sido guardado satisfactoriamente :)", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el grupo", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite listar todos los grupos")
	@GetMapping(value = "ListaGrupos")
	public ResponseEntity<List<Grupo>> listarGrupos() {
		List<Grupo> lista = service.ListarTodosGrupos();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Grupo>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar un Grupo por su id")
	@GetMapping(value = "Grupo-id")
	public ResponseEntity<?> grupoById(@RequestParam String id) {
		Grupo grupoFind = service.buscarGrupoPorId(id);

		return new ResponseEntity<Grupo>(grupoFind, HttpStatus.OK);

	}
}
