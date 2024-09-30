package com.toure.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.CategoryApi;
import com.toure.project.dto.CategoryDto;
import com.toure.project.service.CategoryService;

@RestController
public class CategoryController implements CategoryApi {
	
	private CategoryService catService;

	@Autowired
	public CategoryController(CategoryService catService) {
		super();
		this.catService = catService;
	}

	@Override
	public ResponseEntity<CategoryDto> save(CategoryDto dto) {
		
		return ResponseEntity.ok(catService.save(dto));
	}

	@Override
	public ResponseEntity<CategoryDto> findById(Integer id) {
		
		return ResponseEntity.ok(catService.findById(id));
	}

	@Override
	public ResponseEntity<CategoryDto> findByCode(String code) {
		
		return ResponseEntity.ok(catService.findByCode(code));
	}

	@Override
	public ResponseEntity<List<CategoryDto>> findAll() {
		
		return ResponseEntity.ok(catService.findAll());
	}

	@Override
	public void delete(Integer id) {
	
		catService.delete(id);
		
	}

}
