package com.toure.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.toure.project.dto.CommandeFournisseurDto;

public class CommandeFournisseurValidator {
	
	public static List<String> validate(CommandeFournisseurDto dto){
		
		List<String> error = new ArrayList();
		
		if(dto == null) {

			error.add("Order provider ID can't be null");
			error.add("The order provider code is required");
			error.add("The order provider date is required");
			error.add("This order is saved without a provider");
			
			return error;
		}
		
		if(dto.getId() == null) {
			error.add("Order provider ID can't be null");
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			error.add("The order provider code is required");
		}
		
		if(dto.getDateCommande() == null) {
			error.add("The order provider date is required");
		}
		
		if(dto.getFournisseur() == null) {
			error.add("This order can't be saved without a provider");
		}
		
		return error;
	}

}
