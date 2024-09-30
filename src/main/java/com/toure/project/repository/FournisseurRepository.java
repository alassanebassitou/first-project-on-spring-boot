package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
	
	Optional<Fournisseur> findByEmail(String email);

}
