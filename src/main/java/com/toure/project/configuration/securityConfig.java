package com.toure.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	@Autowired
	private UtilisateurDetailsService utilisateurDetailsService;
	
	@Autowired
	private MiddlewareService middleService;
	
	//private
	

	@Bean
	AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		
		daoAuth.setUserDetailsService(utilisateurDetailsService);
		daoAuth.setPasswordEncoder(passwordEncoder());
		
		return daoAuth;
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf()
				.disable()
				.authorizeHttpRequests()
				.requestMatchers("/**/login",
						"/**/entreprise/create",
						"/**/user/create",
						"/**/role/find_name/**",
						"/**/role/create",
						"/**/user/all",
						"/v2/api-docs",
						"/swagger-resources",
						"/swagger-resources/**",
						"/configuration/ui",
						"/configuration/security",
						"/swagger-ui.html",
						"/webjars/**",
						"/v3/api-docs/**",
						"/swagger-ui/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(middleService, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
}
