package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.EntrepriseApi;
import com.toure.project.dto.EntrepriseDto;
import com.toure.project.service.EntrepriseService;

@RestController
public class EntrepriseController implements EntrepriseApi {
	
	private EntrepriseService entrepoService;

	@Autowired
	public EntrepriseController(EntrepriseService entrepoService) {
		super();
		this.entrepoService = entrepoService;
	}

	@Override
	public ResponseEntity<EntrepriseDto> save(EntrepriseDto dto) {
		
		return ResponseEntity.ok(entrepoService.save(dto));
	}

	@Override
	public ResponseEntity<EntrepriseDto> findById(Integer id) {
		
		return ResponseEntity.ok(entrepoService.findById(id));
	}

	@Override
	public ResponseEntity<EntrepriseDto> findByCode(String nom) {
		
		return ResponseEntity.ok(entrepoService.findByName(nom));
	}

	@Override
	public ResponseEntity<List<EntrepriseDto>> findAll() {
		
		return ResponseEntity.ok(entrepoService.findAll());
	}

	@Override
	public void delete(Integer id) {

		entrepoService.delete(id);

	}

}
