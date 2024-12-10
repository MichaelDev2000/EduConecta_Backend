package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Peticionesamistad;
import com.educonecta.app.service.IPeticionAmistadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Peticiones de amistad", description = "Este controlador nos permite gestionar las peticiones de amistad.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "ApiPeticiones")
public class PeticionAmistadController {

	@Autowired
	IPeticionAmistadService service;

	@Operation(summary = "Este endpoint permite  registrar una peticion.")
	@PostMapping(value = "registrarPeticion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarPeticion(@RequestBody Peticionesamistad peticion) {
		if (service.registrarPeticion(peticion)) {
			return new ResponseEntity<String>("La peticion ha sido guardada satisfatoriamente", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Error al guardar peticion.", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint permite obtener las peticiones pendientes de amistad.")
	@GetMapping("pendientes")
	public ResponseEntity<List<Peticionesamistad>> obtenerPeticionesPendientes(@RequestParam String idUsuarioDestino) {
	    List<Peticionesamistad> peticionesPendientes = service.listarPeticionesPendientesRecibidas(idUsuarioDestino);
	    
	    if (peticionesPendientes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<>(peticionesPendientes, HttpStatus.OK);
	}


	@Operation(summary = "Este endpoint nos permite obtener todas las peticiones de la base de datos.")
	@GetMapping(value = "ListaPeticiones")
	public ResponseEntity<?> listarPeticiones() {
		List<Peticionesamistad> lista = service.listarPeticiones();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		return new ResponseEntity<List<Peticionesamistad>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar una peticion por su ID")
	@GetMapping(value = "peticion-id")
	public ResponseEntity<?> peticionById(@RequestParam String id) {
		Peticionesamistad peticionFind = service.buscarPorId(id);
		if (peticionFind != null) {
			return new ResponseEntity<Peticionesamistad>(peticionFind, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al encontrar peticion con ID: " + id + " ", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite eliminar una peticion por su ID")
	@DeleteMapping(value = "deletePeticionId")
	public ResponseEntity<?> deletePostById(@RequestParam String id) {
		if (service.borrarPeticion(id)) {
			return new ResponseEntity<String>("La peticion con id " + id + " Ha sido eliminado satisfactoriamente",
					HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al intentar borrar peticion con id " + id + ".", HttpStatus.CONFLICT);
	}

}
