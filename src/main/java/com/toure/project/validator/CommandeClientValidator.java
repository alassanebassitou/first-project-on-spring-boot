package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.CommandeClientDto;

public class CommandeClientValidator {
	
	public static List<String> validate(CommandeClientDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {

			error.add("Order custumer ID can't be null");
			error.add("The order custumer code is required");
			error.add("The order custumer date is required");
			error.add("This order can't be saved without a custumer");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("Order custumer ID can't be null");
		}
		
		if(!StringUtils.hasLength(dto.getCodeCom())) {
			error.add("The order custumer code is required");
		}
		
		if(dto.getDateCommande() == null) {
			error.add("The order custumer date is required");
		}
		
		if(dto.getClient() == null) {
			error.add("This order can't be saved without a custumer");
		}
		
		return error;
	}
	

}
