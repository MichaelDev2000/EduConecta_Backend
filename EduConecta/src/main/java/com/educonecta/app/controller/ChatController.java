package com.educonecta.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.entity.Chat;
import com.educonecta.app.entity.ChatMessage;
import com.educonecta.app.entity.Mensageschat;
import com.educonecta.app.service.IChatService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de Chats", description = "Controlador para la gestion de chats")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "ApiChats")
public class ChatController {

	@Autowired
	IChatService service;

	@Operation(summary = "Este endpoint permite crear o registrar un chat.")
	@PostMapping(value = "registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegistrarChat(@RequestBody Chat chat) {
		if (service.registrarChat(chat)) {
			return new ResponseEntity<String>("El Chat ha sido guardado satisfactoriamente :)", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Ha habido un error al guardar el chat", HttpStatus.CONFLICT);
	}


	@Operation(summary = "Este endpoint nos permite listar todos los chats")
	@GetMapping(value = "ListaChats")
	public ResponseEntity<List<Chat>> listarChats() {
		List<Chat> lista = service.ListarTodosChats();
		int cantList = lista.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("Test", "Hola");
		return new ResponseEntity<List<Chat>>(lista, headers, HttpStatus.ACCEPTED);
	}
	
	private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage sendMessage(ChatMessage chatMessage, @DestinationVariable String roomId) {
        return chatMessage; 
    }
    
	@Operation(summary = "Este endpoint nos permite recuperar un Chat por su Id")
	@GetMapping(value = "Chat-id")
	public ResponseEntity<?> chatById(@RequestParam String id) {
		Chat chatFind = service.buscarChatPorId(id);

		return new ResponseEntity<Chat>(chatFind, HttpStatus.OK);
	}
}
