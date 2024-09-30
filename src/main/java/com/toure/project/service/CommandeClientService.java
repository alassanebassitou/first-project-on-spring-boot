package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.CommandeClientDto;

public interface CommandeClientService {
	
	CommandeClientDto save(CommandeClientDto dto);
	
	CommandeClientDto findById(Integer id);
	
	CommandeClientDto findByCodeCom(String code);
	
	List<CommandeClientDto> findAll();
	
	void delete(Integer id);

}
