package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.VenteApi;
import com.toure.project.dto.VenteDto;
import com.toure.project.service.VenteService;


@RestController
public class VenteController implements VenteApi {
	
	private VenteService venteS;

	@Autowired
	public VenteController(VenteService venteS) {
		super();
		this.venteS = venteS;
	}

	@Override
	public ResponseEntity<VenteDto> save(VenteDto dto) {
		
		return ResponseEntity.ok(venteS.save(dto));
	}

	@Override
	public ResponseEntity<VenteDto> findById(Integer id) {
		
		return ResponseEntity.ok(venteS.findById(id));
	}

	@Override
	public ResponseEntity<VenteDto> findByCodeVent(String code) {
		
		return ResponseEntity.ok(venteS.findByCodeVent(code));
	}

	@Override
	public ResponseEntity<List<VenteDto>> findAll() {
		
		return ResponseEntity.ok(venteS.findAll());
	}

	@Override
	public void delete(Integer id) {
		
		venteS.delete(id);

	}

}
