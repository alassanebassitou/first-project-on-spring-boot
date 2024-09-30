package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.UtilisateurDto;

public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {
			
			error.add("User ID can't be null");
			error.add("The user lastname is required");
			error.add("The user firstname is required");
			error.add("The user email is required");
			error.add("User address is important");
			error.add("The password is required");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("User ID can't be null");
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			error.add("The User lastname is required");
		}
		
		if(!StringUtils.hasLength(dto.getPrenom())) {
			error.add("The user firstname is required");
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			error.add("The user email is required");
		}
		
		if(dto.getAdresse() == null) {
			error.add("User address is important");
		}
		
		if(!StringUtils.hasLength(dto.getMotDePasse())) {
			error.add("The password is required");
		}
		
		return error;
	}

}
