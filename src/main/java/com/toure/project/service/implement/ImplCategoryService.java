package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.toure.project.dto.CategoryDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Category;
import com.toure.project.repository.CategoryRepository;
import com.toure.project.service.CategoryService;
import com.toure.project.validator.CategoryValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplCategoryService implements CategoryService {
	
	private CategoryRepository catRepository;
	
	@Autowired
	public ImplCategoryService(CategoryRepository catRepository) {
		this.catRepository = catRepository;
	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		List<String> error = CategoryValidator.validate(dto);
		if(!error.isEmpty()) {
			log.error("This object is invalide");
			throw new InvalidEntityException("", ErrorCodes.CATEGORY_INVALID, error);
		}
		
		
		
		return CategoryDto.fromEntity(
				catRepository.save(CategoryDto.toEntity(dto))
				);
	}

	@Override
	public CategoryDto findById(Integer id) {
		if( id == null) {
			log.warn("This ID is null");
			return null;
		}
		
		Optional<Category> category = catRepository.findById(id);
		
		return Optional.of(
				CategoryDto.fromEntity(category.get())
				).orElseThrow(()-> new EntityNotFoundException("This category of "+ id +" that you seach in data base is not found", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public CategoryDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.warn("This code is null");
			return null;
		}
		Optional<Category> category = catRepository.findByCode(code);
		
		
		return Optional.of(
				CategoryDto.fromEntity(category.get())
				).orElseThrow(()-> new EntityNotFoundException("This category of "+ code +" that you seach in data base is not found", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public List<CategoryDto> findAll() {
		
		return catRepository.findAll().stream()
				.map(CategoryDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if( id == null) {
			log.warn("This ID is null");
		}
		
		catRepository.deleteById(id);
	}

}
