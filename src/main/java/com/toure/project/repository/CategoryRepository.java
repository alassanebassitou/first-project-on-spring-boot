package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toure.project.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
	@Query( value = "SELECT c FROM Category c WHERE c.code = :code")
	Optional<Category> findByCode(String code);

}
