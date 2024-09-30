package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.ClientDto;

public interface ClientService {
	
	ClientDto save(ClientDto dto);
	
	ClientDto findById(Integer id);
	
	ClientDto findByEmail(String email);
	
	List<ClientDto> findAll();
	
	void delete(Integer id);

}
