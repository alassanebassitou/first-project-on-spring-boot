package com.toure.project.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.toure.project.dto.auth.RequestService;
import com.toure.project.model.Utilisateur;
import com.toure.project.repository.UtilisateurRepository;

//@Service
public class AuthenticateService {
	
	private UtilisateurRepository useRepository;
	
	private AuthenticationManager authenticationManager;
	
	//@Autowired
	public AuthenticateService(UtilisateurRepository useRepository, AuthenticationManager authenticationManager) {
		super();
		this.useRepository = useRepository;
		this.authenticationManager = authenticationManager;
	}
	
	public Utilisateur autenticate(RequestService request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getEmail(),
				request.getPassword()
				));
		
		return useRepository.findByEmail(request.getEmail()).orElseThrow();
	}

	

}
