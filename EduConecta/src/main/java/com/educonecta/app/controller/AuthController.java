package com.educonecta.app.controller;

import static com.educonecta.app.utils.Tools.CLAVE;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.app.dto.LoginResponse;
import com.educonecta.app.dto.UsuarioDTO;
import com.educonecta.app.entity.Usuario;
import com.educonecta.app.service.IUsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Controlador para login con JWT", description = "Controlador para login con JWT")
@CrossOrigin(origins = "*")
@RestController
public class AuthController {
	
	@Autowired
	IUsuarioService servicio;

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authManager) {
		super();
		this.authManager = authManager;
	}

	@Operation(summary = "Este endpoint permite loguearnos para obtener el token a traves de JWT")
	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestParam("Correo") String correo,
			@RequestParam("Contraseña") String contrasena) {
		try {
			// Cargar los detalles del usuario
			UserDetails user = userDetailsService.loadUserByUsername(correo);

			// Comparar las contraseñas
			if (user != null && passwordEncoder.matches(contrasena, user.getPassword())) {
				Authentication authentication = authManager
						.authenticate(new UsernamePasswordAuthenticationToken(correo, contrasena));
				
				String token = getToken(authentication);
				
				UsuarioDTO usuario = servicio.obtenerPorCorreo(correo);
				
				LoginResponse respuesta = new LoginResponse(token, usuario);

				return new ResponseEntity<LoginResponse>(respuesta,HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
			}
		} catch (AuthenticationException ex) {
			return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
		}
	}

	private String getToken(Authentication authentication) {
		String token = Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(authentication.getName()) // El correo
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 día
				.signWith(Keys.hmacShaKeyFor(CLAVE.getBytes())).compact();
		return token;
	}

}
