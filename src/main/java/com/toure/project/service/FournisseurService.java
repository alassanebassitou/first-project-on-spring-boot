package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.FournisseurDto;

public interface FournisseurService {
	
	FournisseurDto save(FournisseurDto dto);
	
	FournisseurDto findById(Integer id);
	
	FournisseurDto findByEmail(String email);
	
	List<FournisseurDto> findAll();
	
	void delete(Integer id);

}
