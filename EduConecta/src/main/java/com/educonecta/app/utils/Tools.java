package com.educonecta.app.utils;

import java.util.regex.Pattern;

public class Tools {

	public static final String CLAVE = "123333333333333aaaaaaaaa900000000";

	public static final String ENCABEZADO = "Authorization";
	public static final String PREFIJO_TOKEN = "Bearer ";
	
	
	public static String [] avatares = {"https://i.ibb.co/P5G8cVc/av1.png",
			"https://i.ibb.co/nf55my3/av2.png",
			"https://i.ibb.co/V28K2tc/av3.png",
			"https://i.ibb.co/5RVgNdV/av4.png",
			"https://i.ibb.co/gz4NnHk/av5.png",
			"https://i.ibb.co/kQt5cMh/av6.png",
			"https://i.ibb.co/syRSv9z/av7.png",
			"https://i.ibb.co/r4WJhDr/av8.png",
			"https://i.ibb.co/xG9twkz/av9.png",
			"https://i.ibb.co/xGZ45wN/av10.png",
			"https://i.ibb.co/rZVtRQc/av11.png",
			"https://i.ibb.co/6yQ8xTK/av12.png"};
	
	//Validaciones
	//validar contraseña
	public static boolean validPassword(String password) {
	    if (password == null || password.isEmpty()) {
	        return false;
	    }
	    String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$*?]{8,}$";
	    return Pattern.compile(passwordRegex).matcher(password).matches();
	}
	//validar correo
	public static boolean validEmail(String email) {
	    if (email == null || email.isEmpty()) {
	        return false;
	    }
	    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    return Pattern.compile(emailRegex).matcher(email).matches();
	}
	//validar nombres
	public static boolean validName(String name) {
	    if (name == null || name.isEmpty()) {
	        return false;
	    }
	    String nameRegex = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$";
	    return Pattern.compile(nameRegex).matcher(name).matches();
	}
	//validar apellidos
	public static boolean validLastname(String lastname) {
	    if (lastname == null || lastname.isEmpty()) {
	        return false;
	    }
	    String lastNameRegex = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$";
	    return Pattern.compile(lastNameRegex).matcher(lastname).matches();
	}
	//validar descripción
	public static boolean validDescription(String description) {
	    if (description == null || description.isEmpty()) {
	        return false;
	    }
	    return description.length() <= 255;
	}
	 public static boolean validarTextoNoVacio(String texto) {
	        return texto != null && !texto.trim().isEmpty();
	    }
}

	

