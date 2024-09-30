package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {
	
	CommandeFournisseurDto save(CommandeFournisseurDto dto);
	
	CommandeFournisseurDto findById(Integer id);
	
	CommandeFournisseurDto findByCodeCom(String code);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete(Integer id);

}
