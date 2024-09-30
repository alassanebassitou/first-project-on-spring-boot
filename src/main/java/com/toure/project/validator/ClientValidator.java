package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.ClientDto;

public class ClientValidator {
		
		public static List<String> validate(ClientDto dto){
			
			List<String> error = new ArrayList();
			if(dto == null) {
				
				error.add("Customer ID can't be null");
				error.add("The customer lastname is required");
				error.add("The customer firstname is required");
				error.add("The customer email is required");
				error.add("Customer address is important");
				
				return error;
			}
			
			if(dto.getId() == null) {
				error.add("Customer ID can't be null");
			}
			
			if(!StringUtils.hasLength(dto.getNom())) {
				error.add("The customer lastname is required");
			}
			
			if(!StringUtils.hasLength(dto.getPrenom())) {
				error.add("The customer firstname is required");
			}
			if(!StringUtils.hasLength(dto.getEmail())) {
				error.add("The customer email is required");
			}
			
			if(dto.getAdresse() == null) {
				error.add("Customer address is important");
			}
			
			return error;
		}

}
