package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.FournisseurApi;
import com.toure.project.dto.FournisseurDto;
import com.toure.project.service.FournisseurService;


@RestController
public class FournisseurController implements FournisseurApi {
	
	private FournisseurService fourService;

	@Autowired
	public FournisseurController(FournisseurService fourService) {
		super();
		this.fourService = fourService;
	}
	
	@Override
	public ResponseEntity<FournisseurDto> save(FournisseurDto dto) {
		
		return ResponseEntity.ok(fourService.save(dto));
	}

	@Override
	public ResponseEntity<FournisseurDto> findById(Integer id) {
		
		return ResponseEntity.ok(fourService.findById(id));
	}

	@Override
	public ResponseEntity<FournisseurDto> findByEmail(String email) {
		
		return ResponseEntity.ok(fourService.findByEmail(email));
	}

	@Override
	public ResponseEntity<List<FournisseurDto>> findAll() {
		
		return ResponseEntity.ok(fourService.findAll());
	}

	@Override
	public void delete(Integer id) {
		
		fourService.delete(id);

	}


}
