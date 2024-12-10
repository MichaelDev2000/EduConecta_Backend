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

import com.educonecta.app.entity.Amistad;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.service.IAmistadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Amistades", description = "Controlador para la gestion de amistades")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "ApiAmistad")
public class AmistadController {

	@Autowired
	IAmistadService service;

	@Operation(summary = "Este endpoint permite crear o registrar una amistad.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarAmistad(@RequestBody Amistad amistad) {
		if (service.registrarAmistad(amistad)) {
			return new ResponseEntity<String>("La amistad ha sido guardada satisfactoriamente", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar la Amistad", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite listar todas las amistades")
	@GetMapping(value = "ListaAmistades")
	public ResponseEntity<List<Amistad>> listarAmistades() {
		List<Amistad> lista = service.ListarTodasAmistades();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Amistad>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar una Amistad por su id")
	@GetMapping(value = "Amistad-id")
	public ResponseEntity<?> amistadById(@RequestParam String id) {
		Amistad amistadFind = service.buscarAmistadPorId(id);

		return new ResponseEntity<Amistad>(amistadFind, HttpStatus.OK);

	}
	
	@Operation(summary = "Este endpoint nos permite listar todos los amigos de un usuario por su id")
	@GetMapping("listarAmigosUsuario")
	public ResponseEntity<List<Usuario>> obtenerAmigosPorUsuarioId(@RequestParam String usuarioId) {
		List<Usuario> amigos = service.listarAmigosPorUsuarioId(usuarioId);
		

		if (amigos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}


		// Devolver la respuesta con la lista de amigos y los headers
		return new ResponseEntity<>(amigos, HttpStatus.OK);
	}

}
