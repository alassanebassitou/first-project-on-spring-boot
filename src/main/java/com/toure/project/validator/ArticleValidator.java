package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.ArticleDto;

public class ArticleValidator {
	
	public static List<String> validate(ArticleDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {
			
			error.add("Article can't have null ID please try againt");
			error.add("Article can't be save with null code");
			error.add("Article designation is null please try againt");
			error.add("The article price HT is null");
			error.add("The article price TTC is null");		
			
			return error;
		}
		
		if(dto.getId() == 0) {
			error.add("Article can't have null ID please try againt");
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			error.add("Article can't be saved with null code");
		}
		
		if(StringUtils.hasLength(dto.getDesignation())) {
			error.add("Article designation is null please try againt");
		}
		
		if(dto.getPrixHT() == null) {
			error.add("The article price HT is null");
		}
		
		if(dto.getPrixTTC() == null) {
			error.add("The article price TTC is null");
		}
		
		return error;
	}

}
