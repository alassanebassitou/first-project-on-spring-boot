package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.CategoryDto;

public class CategoryValidator {
	
	public static List<String> validate(CategoryDto dto){
		List<String> error = new ArrayList();
		if(dto == null) {
			error.add("Category ID can't be null please try againt");
			error.add("The Category code is required");
			error.add("The cateory designation can't be null");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("Category ID can't be null please try againt");
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			error.add("The Category code is required");
		}
		
		if(!StringUtils.hasLength(dto.getDesignation())) {
			error.add("The cateory designation can't be null");
		}
		
		return error;
	}

}
