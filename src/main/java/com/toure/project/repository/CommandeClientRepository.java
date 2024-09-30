package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer>{
	
	Optional<CommandeClient> findByCodeCom(String code);

}
