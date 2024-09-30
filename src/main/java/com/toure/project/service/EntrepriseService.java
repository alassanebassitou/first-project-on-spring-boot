package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.EntrepriseDto;

public interface EntrepriseService {
	
	EntrepriseDto save(EntrepriseDto dto);
	
	EntrepriseDto findById(Integer id);
	
	EntrepriseDto findByName(String name);
	
	List<EntrepriseDto> findAll();
	
	void delete(Integer id);

}
