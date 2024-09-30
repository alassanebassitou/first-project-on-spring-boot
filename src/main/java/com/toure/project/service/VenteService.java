package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.VenteDto;

public interface VenteService {
	
	VenteDto save(VenteDto dto);
	
	VenteDto findById(Integer id);
	
	VenteDto findByCodeVent(String code);
	
	List<VenteDto> findAll();
	
	void delete(Integer id);

}
