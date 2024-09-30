package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer>{
	
	Optional<Entreprise> findByName(String name);

}
