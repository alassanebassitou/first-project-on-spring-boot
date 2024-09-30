package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toure.project.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
	
	@Query("select u from Utilisateur u where u.email = :email")
	Optional<Utilisateur> findByEmail(String email);

}
