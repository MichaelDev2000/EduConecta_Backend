package com.educonecta.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Publicacion;
import com.educonecta.app.service.IPublicacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Publicaciones", description = "Controlador para la gestion de publicaciones")
@RestController
@RequestMapping(value = "ApiPost")
public class PublicacionesController {
	@Autowired
	IPublicacionService service;

	@Operation(summary = "Este endpoint permite crear o registrar un rol.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarPublicacion(@RequestBody Publicacion publicacion) {
		if (service.registrarPublicacion(publicacion)) {
			return new ResponseEntity<String>("La publicacion ha sido guardada satisfatoriamente", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("", HttpStatus.CONFLICT);
	}

}
