package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.ArticleDto;

public interface ArticleService {
	
	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCode(String code);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);

}
