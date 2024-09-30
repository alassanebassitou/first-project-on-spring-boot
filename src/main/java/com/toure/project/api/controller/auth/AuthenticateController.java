package com.toure.project.api.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.configuration.UtilisateurDetailsService;
import com.toure.project.dto.auth.AuthenticateResponse;
import com.toure.project.dto.auth.RequestService;
import com.toure.project.service.JwtService;


@RestController
@RequestMapping("/auth")
public class AuthenticateController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UtilisateurDetailsService usDetailsService; 
	
	@PostMapping(value = "/login",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody RequestService request){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getEmail(),
				request.getPassword()
				));
		
		UserDetails user = usDetailsService.loadUserByUsername(request.getEmail());
		
		final String token = jwtService.generateToken(user);
		AuthenticateResponse authResponse = new AuthenticateResponse();
		authResponse.setAccessToken(token);
		
		return ResponseEntity.ok(authResponse);
	}
 
}
