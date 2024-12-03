package com.educonecta.app.utils;

import static com.educonecta.app.utils.Tools.CLAVE;
import static com.educonecta.app.utils.Tools.ENCABEZADO;
import static com.educonecta.app.utils.Tools.PREFIJO_TOKEN;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizationFilterJWT extends BasicAuthenticationFilter {

	public AuthorizationFilterJWT(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    String header = request.getHeader(ENCABEZADO);

	    if (header == null || !header.startsWith(PREFIJO_TOKEN)) {
	        chain.doFilter(request, response);
	        return;
	    }

	    UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
	    if (authentication != null) {
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }
	    chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
	    String token = request.getHeader(ENCABEZADO);
	    if (token != null) {
	        try {
	            Claims claims = Jwts.parserBuilder()
	                .setSigningKey(CLAVE.getBytes())
	                .build()
	                .parseClaimsJws(token.replace(PREFIJO_TOKEN, ""))
	                .getBody();

	            String user = claims.getSubject();
	            Date expiration = claims.getExpiration();

	            if (expiration.before(new Date())) {
	                throw new JwtException("Token expirado");
	            }

	            if (user != null) {
	                return new UsernamePasswordAuthenticationToken(user, null, null);
	            }
	        } catch (JwtException e) {
	            throw new RuntimeException("Token no válido: " + e.getMessage());
	        }
	    }
	    return null;
	}
}
