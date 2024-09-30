package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String> validate(EntrepriseDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {
			error.add("Company ID can't be null please try againt");
			error.add("The company code is required");
			error.add("The company description can't be null");
			error.add("Company address is important");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("Company ID can't be null please try againt");
		}
		
		if(!StringUtils.hasLength(dto.getName())) {
			error.add("The company code is required");
		}
		
		if(!StringUtils.hasLength(dto.getDescription())) {
			error.add("The company description can't be null");
		}
		
		if(dto.getAdresse() == null) {
			error.add("Company address is important");
		}
		
		return error;
	}

}
