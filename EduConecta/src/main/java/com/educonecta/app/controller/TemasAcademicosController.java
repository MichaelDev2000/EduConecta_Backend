package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Temaacademico;
//import com.educonecta.app.entity.Temaacademico;
import com.educonecta.app.service.ITemaAcademicoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API de los temas academicos", description="Controlador para la gestion de los temas academicos.")
@RestController
@RequestMapping(value="apiTemasAcademicos")
public class TemasAcademicosController {
	
	@Autowired
	ITemaAcademicoService service;

	@GetMapping(value="saludo")
	public String saludo() {
		return "HOla";
	}
	
	
	@PostMapping(value="registrarTema",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarTema(@RequestBody Temaacademico tema) {
		if(service.registrarTema(tema)) {
			return new ResponseEntity<String>("Se ha creado exitosamente el Tema Academico.",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error interno al guardar el Tema Academico",HttpStatus.CONFLICT);
	}
}
