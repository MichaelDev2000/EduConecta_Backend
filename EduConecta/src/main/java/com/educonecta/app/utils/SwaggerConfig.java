package com.educonecta.app.utils;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
		info=@Info(
				title = "API de servicios de EduConecta",
				description = "Documentacion del API de EduConecta con SpringBoot",
				termsOfService = "Debe aceptar terminos y condiciones",
				contact = @Contact(name = "maicolpr19@gmail.com",
				url = "www.google.com")),
		security = @SecurityRequirement(name = "Security TokenJWT"
				)
		)
@SecurityScheme(
		name = "Security TokenJWT",
		description = "Security con JWT",
		type = SecuritySchemeType.HTTP,
		paramName = HttpHeaders.AUTHORIZATION,
		in = SecuritySchemeIn.HEADER,
		scheme = "bearer", bearerFormat = "JWT")
public class SwaggerConfig {

}
