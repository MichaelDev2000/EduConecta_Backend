package com.educonecta.app.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Temaacademico;
import com.educonecta.app.service.ITemaAcademicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API de los temas academicos", description="Controlador para la gestion de los temas academicos.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="apiTemasAcademicos")
public class TemasAcademicosController {
	
	@Autowired
	ITemaAcademicoService service;
	
	@Operation(summary="Este endpoint nos permite guardar un nuevo tema de interes")
	@PostMapping(value="registrarTema",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarTema(@RequestBody Temaacademico tema) {
		if(service.registrarTema(tema)) {
			return new ResponseEntity<String>("Se ha creado exitosamente el Tema Academico.",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error interno al guardar el Tema Academico",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite listar todos los temas de interes")
	@GetMapping(value="listarTemas")
	public ResponseEntity<List<Temaacademico>> ListarTemas(){
		List<Temaacademico> list = service.ListarTodosTemas();
		//1.Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		//2. armamos la respuesta de tipo ResponseEntity
		return new ResponseEntity<List<Temaacademico>>(list, headers,HttpStatus.ACCEPTED);
	}
	
	@Operation(summary="Este endpoint nos permite consultar un tema por su ID")
	@GetMapping(value="consultarTema")
	public ResponseEntity<?> consultarTemaId(@RequestParam String id){
		Temaacademico tema = service.buscarTemaPorId(id);
		if(tema != null) {
			return new ResponseEntity<Temaacademico>(tema,HttpStatus.OK);
		}return new ResponseEntity<String>("Error al consultar tema con ID: "+id+".",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite modificar un tema")
	@PutMapping(value="modificarTema" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarTema(@RequestBody Temaacademico tema){
		if(service.actualizarTema(tema)) {
			return new ResponseEntity<String>("El tema se actualizo satisfactoriamente",HttpStatus.OK);
		} return new ResponseEntity<String>("Error interno al intentar actualizar el tema.",HttpStatus.CONFLICT);
	}
	
}
