package com.toure.project.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toure.project.model.Article;

import jakarta.persistence.Id;


public interface ArticleRepository extends JpaRepository<Article,Integer> {
	
	Optional<Article> findArticleByCode(String code);

}
