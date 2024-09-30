package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.UtilisateurApi;
import com.toure.project.dto.UtilisateurDto;
import com.toure.project.service.UtilisateurService;


@RestController
public class UtilisateurController implements UtilisateurApi {
	
	private UtilisateurService userService;
	
	@Autowired
	public UtilisateurController(UtilisateurService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public ResponseEntity<UtilisateurDto> save(UtilisateurDto dto) {
		
		return ResponseEntity.ok(userService.save(dto));
	}

	@Override
	public ResponseEntity<UtilisateurDto> findById(Integer id) {
		
		return ResponseEntity.ok(userService.findById(id));
	}

	@Override
	public ResponseEntity<UtilisateurDto> findByEmail(String email) {
		
		return ResponseEntity.ok(userService.findByEmail(email));
	}

	@Override
	public ResponseEntity<List<UtilisateurDto>> findAll() {
		
		return ResponseEntity.ok(userService.findAll());
	}

	@Override
	public void delete(Integer id) {
		
		userService.delete(id);

	}

}
