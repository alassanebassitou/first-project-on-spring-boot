package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.CommandeFournisseurApi;
import com.toure.project.dto.CommandeFournisseurDto;
import com.toure.project.service.CommandeFournisseurService;


@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
	
	private CommandeFournisseurService commandFour;

	@Autowired
	public CommandeFournisseurController(CommandeFournisseurService commandFour) {
		super();
		this.commandFour = commandFour;
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto dto) {
		
		return ResponseEntity.ok(commandFour.save(dto));
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> findById(Integer id) {
		
		return ResponseEntity.ok(commandFour.findById(id));
	}

	@Override
	public ResponseEntity<CommandeFournisseurDto> findByCodeCom(String code) {
		
		return ResponseEntity.ok(commandFour.findByCodeCom(code));
	}

	@Override
	public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
		
		return ResponseEntity.ok(commandFour.findAll());
	}

	@Override
	public void delete(Integer id) {

		commandFour.delete(id);

	}

}
