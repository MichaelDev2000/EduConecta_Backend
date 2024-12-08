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

import com.educonecta.app.entity.Notificacion;
import com.educonecta.app.service.INotificacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="API de Notificaciones", description="Controlador para la gestion de las notificaciones")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="ApiNotificaciones")
public class NotificacionController {
	
	@Autowired
	INotificacionService service;

	
	@Operation(summary="Este endpoint permite crear o registrar una notificacion.")
	@PostMapping(value="registrarNotificacion",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarNotificacion(@RequestBody Notificacion notificacion) {
		if(service.registrarNotificacion(notificacion)) {
			return new ResponseEntity<String>("La notificacion ha sido guardado satisfactoriamente papus :)",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Error interno al guardar la notificacion.",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite listar todas las notificaciones que hay guardadss.")
	@GetMapping(value="AllNotificaciones")
	public ResponseEntity<?> listarTemasInteres(){
		List<Notificacion> list = service.listarNotificaciones();
		//1.Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		System.out.println(list);
		//2. armamos la respuesta de tipo ResponseEntity
		return new ResponseEntity<List<Notificacion>>(list, headers,HttpStatus.ACCEPTED);
	}
	
	@Operation(summary="Este endpoint nos permite consultar una notificacion por su ID.")
	@GetMapping(value="getNotificacionById")
	public ResponseEntity<?> buscarTemaInteresById(@RequestParam String id){
		Notificacion notificacion = service.buscarPorId(id);
		if(notificacion != null) {
			return new ResponseEntity<Notificacion>(notificacion,HttpStatus.OK);
		}return new ResponseEntity<String>("Error interno al consultar notificacion.",HttpStatus.CONFLICT);
	}
	
	@Operation(summary="Este endpoint nos permite eliminar una notificacion.")
	@DeleteMapping(value="deleteNotificacionId")
	public ResponseEntity<?> borrarTemaInteresId(@RequestParam String id){
		if(service.borrarNotificacion(id)) {
			return new ResponseEntity<String>("Notificacion eliminada Satisfactoriamente",HttpStatus.OK);
		} return new ResponseEntity<String>("Error interno al eliminar notificacion.",HttpStatus.CONFLICT);
	}
}
