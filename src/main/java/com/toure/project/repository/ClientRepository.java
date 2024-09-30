package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{
	
	Optional<Client> findByEmail(String email);

}
