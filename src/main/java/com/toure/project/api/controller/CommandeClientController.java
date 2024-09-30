package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.CommandeClientApi;
import com.toure.project.dto.CommandeClientDto;
import com.toure.project.service.CommandeClientService;

@RestController
public class CommandeClientController implements CommandeClientApi {
	
	private CommandeClientService commandclientservice;

	@Autowired
	public CommandeClientController(CommandeClientService commandclientservice) {
		super();
		this.commandclientservice = commandclientservice;
	}

	@Override
	public ResponseEntity<CommandeClientDto> save(CommandeClientDto dto) {
		
		return ResponseEntity.ok(commandclientservice.save(dto));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findById(Integer id) {
		
		return ResponseEntity.ok(commandclientservice.findById(id));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findByCodeCom(String code) {
		
		return ResponseEntity.ok(commandclientservice.findByCodeCom(code));
	}

	@Override
	public ResponseEntity<List<CommandeClientDto>> findAll() {
		
		return ResponseEntity.ok(commandclientservice.findAll());
	}

	@Override
	public void delete(Integer id) {
		
		commandclientservice.delete(id);

	}

}
