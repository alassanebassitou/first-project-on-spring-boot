package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.AdressDto;

public class AdresseValidator {
	
	public static List<String> validate(AdressDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {

			error.add("The first address is required");
			error.add("City is required");
			error.add("Country is required");
			error.add("The postal code is required");
			
			return error;
		}
		
		if(!StringUtils.hasLength(dto.getAdresse1())) {
			error.add("The first address is required");
		}
		
		if(!StringUtils.hasLength(dto.getVille())) {
			error.add("City is required");
		}
		
		if(!StringUtils.hasLength(dto.getPays())) {
			error.add("Country is required");
		}
		
		if(!StringUtils.hasLength(dto.getCodePostal())) {
			error.add("The postal code is required");
		}
		
		return error;
	}
		
		

}
