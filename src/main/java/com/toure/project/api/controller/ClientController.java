package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.ClientApi;
import com.toure.project.dto.ClientDto;
import com.toure.project.service.ClientService;

@RestController
public class ClientController implements ClientApi {
	
	private ClientService cliservice;

	@Autowired
	public ClientController(ClientService cliservice) {
		super();
		this.cliservice = cliservice;
	}

	@Override
	public ResponseEntity<ClientDto> save(ClientDto dto) {
		
		return ResponseEntity.ok(cliservice.save(dto));
	}

	@Override
	public ResponseEntity<ClientDto> findById(Integer id) {
		
		return ResponseEntity.ok(cliservice.findById(id));
	}

	@Override
	public ResponseEntity<ClientDto> findByEmail(String email) {
		
		return ResponseEntity.ok(cliservice.findByEmail(email));
	}

	@Override
	public ResponseEntity<List<ClientDto>> findAll() {
		
		return ResponseEntity.ok(cliservice.findAll());
	}

	@Override
	public void delete(Integer id) {
		
		cliservice.delete(id);
		
	}

}
