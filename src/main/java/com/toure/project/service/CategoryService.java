package com.toure.project.service;

import java.util.List;

import com.toure.project.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto save(CategoryDto dto);
	
	CategoryDto findById(Integer id);
	
	CategoryDto findByCode(String code);
	
	List<CategoryDto> findAll();
	
	void delete(Integer id);

}
