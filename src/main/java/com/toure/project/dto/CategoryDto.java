package com.toure.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
	
	private Integer id;
	
	private String code;
	
	private String designation;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<ArticleDto> article;
	
	
	public static CategoryDto fromEntity(Category cat) {
		if(cat == null) {
			//TODO Throw exception
			return null;
		}
		return CategoryDto.builder()
				.id(cat.getId())
				.code(cat.getCode())
				.designation(cat.getDesignation())
				.idEntreprise(cat.getIdEntreprise())
				.build();
	}
	
	public static Category toEntity(CategoryDto dto) {
		
		Category cate = new Category();
		
		cate.setId(dto.getId());
		cate.setCode(dto.getCode());
		cate.setDesignation(dto.getDesignation());
		cate.setIdEntreprise(dto.getIdEntreprise());
		//cate.setArticle(ArticleDto.toEnt);
		
		return cate;
	}

}
