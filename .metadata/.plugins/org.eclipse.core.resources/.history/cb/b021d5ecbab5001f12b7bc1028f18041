package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Miembrosgrupo;
import com.educonecta.app.service.IMiembrosGrupoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="API de Miembros de grupos")
@RestController
@RequestMapping(value="ApiMiembros")
public class MiembrosGrupoController {
	
	@Autowired
	IMiembrosGrupoService service;
	
	@Operation(summary = "Este endpoint permite crear o registrar un rol.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarMiembros(@RequestBody Miembrosgrupo miembros) {
		if (service.registrarMiembros(miembros)) {
			return new ResponseEntity<String>("El miembro ha sido registrado satisfatoriamente", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Error al guardar el miebro.", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite obtener todas las publicaciones de la base de datos.")
	@GetMapping(value = "ListaPosts")
	public ResponseEntity<?> listarMiembros() {
		List<Miembrosgrupo> lista = service.ListarMiembros();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		return new ResponseEntity<List<Miembrosgrupo>>(lista, headers, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Este endpoint nos permite recuperar un miembro de grupo por su ID")
	@GetMapping(value = "MiembroGrupo-id")
	public ResponseEntity<?> MiembroGrupoById(@RequestParam String id) {
		Miembrosgrupo miembroGrupoFind = service.buscarPorId(id);
		if (miembroGrupoFind != null) {
			return new ResponseEntity<Miembrosgrupo>(miembroGrupoFind, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al encontrar miembro grupo con ID: " + id + " ", HttpStatus.CONFLICT);
	}

	@Operation(summary = "Este endpoint nos permite eliminar un miembro de grupo por su ID")
	@DeleteMapping(value = "deleteMiembroGrupoId")
	public ResponseEntity<?> deleteMiembroGrupoById(@RequestParam String id) {
		if (service.borrarMiembro(id)) {
			return new ResponseEntity<String>("El miembro grupo con id " + id + " Ha sido eliminado satisfactoriamente",
					HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al intentar borrar miembro grupo con id " + id + ".", HttpStatus.CONFLICT);
	}
}
