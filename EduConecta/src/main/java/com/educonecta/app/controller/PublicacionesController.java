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

import com.educonecta.app.dto.PublicacionDTO;
import com.educonecta.app.entity.Publicacion;
import com.educonecta.app.service.IPublicacionService;
import com.educonecta.app.utils.Tools;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Publicaciones", description = "Controlador para la gestion de publicaciones")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "ApiPost")
public class PublicacionesController {
	@Autowired
	IPublicacionService service;

	@Operation(summary = "Este endpoint permite crear o registrar una publicacion.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarPublicacion(@RequestBody Publicacion publicacion) {
		if (service.registrarPublicacion(publicacion)) {
			if (!Tools.validarTextoNoVacio(publicacion.getPostContenido())) {
				 return new ResponseEntity<>("El comentario no puede ser vacio.", HttpStatus.BAD_REQUEST);
		        }
			return new ResponseEntity<String>("La publicacion ha sido guardada satisfatoriamente", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error al guardar Publicacion.", HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite recuperar todas las publicaciones ordenadas de nuevas a antiguas")
	@GetMapping(value="ListarPostOrdenados")
	public ResponseEntity<List<PublicacionDTO>> listarPublicacionesOrdenadas() {
	    List<PublicacionDTO> publicaciones = service.ListarPostOrdenados();
	    return new ResponseEntity<List<PublicacionDTO>>(publicaciones, HttpStatus.OK);
	}
	
	@Operation(summary="Este endpoint nos permite obtener todas las publicaciones de la base de datos.")
	@GetMapping(value="ListaPosts")
	public ResponseEntity<?> listarPublicaciones(){
		List<Publicacion> lista = service.ListarTodosPost();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Publicacion>>(lista, headers, HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "Este endpoint nos permite recuperar un post por su ID")
	@GetMapping(value = "post-id")
	public ResponseEntity<?> rolById(@RequestParam String id) {
		Publicacion publicacionFind = service.buscarPublicacionPorId(id);
		if(publicacionFind != null) {
			return new ResponseEntity<Publicacion>(publicacionFind, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al encontrar post con ID: "+id+" ",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite eliminar un post pot su ID")
	@DeleteMapping(value="deletePostId")
	public ResponseEntity<?> deletePostById(@RequestParam String id){
		if(service.borrarPublicacionId(id)) {
			return new ResponseEntity<String>("El post con id "+id+" Ha sido eliminado satisfactoriamente",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error al intentar borrar postcon id "+id+".",HttpStatus.CONFLICT);
	}
	
	

}
