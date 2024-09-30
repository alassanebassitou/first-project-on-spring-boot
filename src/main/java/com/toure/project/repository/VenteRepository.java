package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.Article;
import com.toure.project.model.Vente;

public interface VenteRepository extends JpaRepository<Vente,Integer> {

	Optional<Vente> findByCodeVent(String code);

}
