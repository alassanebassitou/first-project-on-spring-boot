package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.toure.project.dto.ArticleDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Article;
import com.toure.project.repository.ArticleRepository;
import com.toure.project.service.ArticleService;
import com.toure.project.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplArticleService implements ArticleService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public ImplArticleService(ArticleRepository articleRepo) {
		this.articleRepository = articleRepo;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		List<String> error = ArticleValidator.validate(dto);
		
		if(!error.isEmpty()) {
			log.warn("This Object is invalid");			
			throw new InvalidEntityException("This article is not valide",ErrorCodes.ARTICLE_INVALID, error);
		}
		
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		
		if(id == null) {
			log.error("Your Article ID is null");
			return null;
		}
		
		Optional<Article> article = articleRepository.findById(id);
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("The article of "+ id +" that you seach in data base is not found", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("This code is null{}", code);
			return null;
		}
		
		Optional<Article> article = articleRepository.findArticleByCode(code);		
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException("The article of code "+ code +" is not exist in data base", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		
		return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Your Article ID is null");
		}
		
		articleRepository.deleteById(id);
	}

}
