package com.educonecta.app.utils;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.educonecta.app.utils.AuthorizationFilterJWT;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  
    }

	
	AuthenticationManager auth;
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration conf) throws Exception {
		auth= conf.getAuthenticationManager();		
		return auth;
	}
	
	@Bean
	public JdbcUserDetailsManager usersDetailsJdbc() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/educonecta");
		ds.setUsername("root");
		ds.setPassword("");
		
		JdbcUserDetailsManager jdbcDetails=new JdbcUserDetailsManager(ds);
		
		jdbcDetails.setUsersByUsernameQuery("select usu_correo, usu_contrasena, usu_status from usuarios where usu_correo=?");
		
		jdbcDetails.setAuthoritiesByUsernameQuery("select usu_correo, rol from roles where usu_correo=?");


		printUsers(ds);
		return jdbcDetails;
	}
	  // Método para imprimir usuarios y roles
    private void printUsers(DriverManagerDataSource ds) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

        // Imprimir usuarios
        List<String> users = jdbcTemplate.query("SELECT usu_correo FROM usuarios", (rs, rowNum) -> rs.getString("usu_correo"));
        System.out.println("Usuarios en la base de datos: " + users);
    }
	
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
		aut.requestMatchers(HttpMethod.GET,"/apiTemasAcademicos/saludo").authenticated()
		//	aut.requestMatchers(HttpMethod.POST,"/api/course").hasRole("ADMINS")
			//.requestMatchers(HttpMethod.DELETE,"/datos/**").hasRole("ADMINS")
			//.requestMatchers(HttpMethod.GET,"/api/courses").hasAnyRole("ADMINS","USERS")
			//.requestMatchers(HttpMethod.GET,"/api/courses-id").hasRole("ADMINS")		
			.anyRequest().permitAll()
			)
		.addFilter(new AuthorizationFilterJWT(auth));
		return http.build();
	}
}
