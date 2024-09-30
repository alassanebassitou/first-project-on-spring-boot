package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
	
	Optional<CommandeFournisseur> findByCodeCom(String code);

}
