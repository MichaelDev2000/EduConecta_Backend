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

import com.educonecta.app.entity.Like;
import com.educonecta.app.service.ILikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Likes", description = "Controlador para la gestion de likes")
@RestController
@RequestMapping(value = "ApiLikes")
public class LikeController {

	@Autowired
	ILikeService service;

	@Operation(summary = "Este endpoint permite crear o registrar un like.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarLike(@RequestBody Like like) {
		if (service.registrarLike(like)) {
			return new ResponseEntity<String>("El Like ha sido guardado satisfactoriamente ", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el Like", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite listar todos los Like")
	@GetMapping(value = "ListaLike")
	public ResponseEntity<List<Like>> listarLike() {
		List<Like> lista = service.ListarTodosLikes();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Like>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar un Like")
	@GetMapping(value = "Like-id")
	public ResponseEntity<?> likeById(@RequestParam String id) {
		Like likeFind = service.buscarLikePorId(id);

		return new ResponseEntity<Like>(likeFind, HttpStatus.OK);

	}
}
