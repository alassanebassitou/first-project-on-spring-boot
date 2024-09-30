package com.toure.project.api.controller;

import static com.toure.project.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.ArticleApi;
import com.toure.project.dto.ArticleDto;
import com.toure.project.service.ArticleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class ArticleController implements ArticleApi {

	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	@Override
	public ResponseEntity<ArticleDto> save(ArticleDto dto) {
		
		return ResponseEntity.ok(articleService.save(dto)) ;
	}

	@Override
	public ResponseEntity<ArticleDto> findById(Integer id) {
		
		return ResponseEntity.ok(articleService.findById(id));
	}

	@Override
	public ResponseEntity<ArticleDto> findByCode(String code) {
		
		return ResponseEntity.ok(articleService.findByCode(code));
	}

	@Override
	public ResponseEntity<List<ArticleDto>> findAll() {
		
		return ResponseEntity.ok(articleService.findAll());
	}

	@Override
	public void delete(Integer id) {

		articleService.delete(id);

	}

}
