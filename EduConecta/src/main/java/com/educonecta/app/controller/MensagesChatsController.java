package com.educonecta.app.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Mensageschat;
import com.educonecta.app.service.IMensagesChatsService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Mensages", description = "Controlador para la gestion de mensages")
@RestController
@RequestMapping(value = "ApiMensages")
public class MensagesChatsController {
	
	@Autowired
	IMensagesChatsService service;
	
	@Operation(summary = "Este endpoint permite crear o registrar un Mensage.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarMensage(@RequestBody Mensageschat mensage){
		if(service.registrarMensage(mensage)) {
			return new ResponseEntity<String>("El mensage ha sido guardado satisfactoriamente ", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el mensage", HttpStatus.CONFLICT);
	}
	
	@Operation(summary = "este endpoint nos permite listar todos los mensages")
	@GetMapping(value = "ListarMensages")
	public ResponseEntity<List<Mensageschat>> listarMensages(){
		List<Mensageschat> lista = service.ListarTodosMsg();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Mensageschat>>(lista, headers, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "este endpoint nos permite recuperar un mensage por su id")
	@GetMapping(value = "Mensage-id")
	public ResponseEntity<?> mensageById(@RequestParam String id){
		Mensageschat mensageFind = service.buscarMensajePorId(id);
		return new ResponseEntity<Mensageschat>(mensageFind, HttpStatus.OK);
	}

}
