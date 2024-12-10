package com.educonecta.app.utils;

import java.util.Date;

import org.springframework.security.core.Authentication;
import static com.educonecta.app.utils.Tools.CLAVE;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {


    public static String generateToken(Authentication authentication) {
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(authentication.getName()) 
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) 
                .signWith(Keys.hmacShaKeyFor(CLAVE.getBytes()))
                .compact();
    }
}
