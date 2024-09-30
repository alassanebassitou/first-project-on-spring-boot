package com.toure.project.dto;

import com.toure.project.model.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdressDto {
	
	private Integer id;
	
	private String adresse1;
	
	private String adresse2;
	
	private String ville;
	
	private String codePostal;
	
	private String pays;
	
	public static AdressDto fromEntity(Adresse adresse) {
		if(adresse == null) {
			//TODO Exception
			
			return null;
		}
		
		return AdressDto.builder()
				.adresse1(adresse.getAdresse1())
				.adresse2(adresse.getAdresse2())
				.ville(adresse.getVille())
				.codePostal(adresse.getCodePostal())
				.pays(adresse.getPays())
				.build();
	}
	
	
	public static Adresse toEntity(AdressDto dto) {
		
		Adresse adresse = new Adresse();
		
		adresse.setAdresse1(dto.getAdresse1());
		adresse.setAdresse2(dto.getAdresse2());
		adresse.setVille(dto.getVille());
		adresse.setCodePostal(null);
		adresse.setCodePostal(dto.getCodePostal());
		
		return adresse;
	}

}
