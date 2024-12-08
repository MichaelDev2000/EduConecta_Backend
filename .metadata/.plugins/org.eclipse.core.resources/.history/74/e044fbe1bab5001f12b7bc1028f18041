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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Comentario;
import com.educonecta.app.service.IComentarioService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Comentarios", description = "Controlador para la gestion de comentarios")
@RestController
@RequestMapping(value = "ApiComentarios")
public class ComentarioController {

	@Autowired
	IComentarioService service;

	@Operation(summary = "Este endpoint permite crear o registrar un comentario.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarComentario(@RequestBody Comentario comentario) {
		if (service.registrarComentario(comentario)) {
			return new ResponseEntity<String>("El Comentario ha sido guardado satisfactoriamente :)", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el Comentario", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite listar todos los comentarios")
	@GetMapping(value = "ListaComentarios")
	public ResponseEntity<List<Comentario>> listarComentarios() {
		List<Comentario> lista = service.ListarTodosComentarios();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Comentario>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar un Comentario por su id")
	@GetMapping(value = "Comentario-id")
	public ResponseEntity<?> comentarioById(@RequestParam String id) {
		Comentario comentarioFind = service.buscarComentarioPorId(id);

		return new ResponseEntity<Comentario>(comentarioFind, HttpStatus.OK);

	}
}
