package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.VenteDto;

public class VenteValidator {
	
	public static List<String> validate(VenteDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {

			error.add("A sale ID can't be null");
			error.add("The sale code is required");
			error.add("The sale date is required");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("A sale ID can't be null");
		}
		
		if(!StringUtils.hasLength(dto.getCodeVente())) {
			error.add("The sale code is required");
		}
		
		if(dto.getDateVent() == null) {
			error.add("The sale date is required");
		}
		
		return error;
	}

}
