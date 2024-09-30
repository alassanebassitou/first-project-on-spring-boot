package com.toure.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private AdressDto adresse;
	
	private String codeFiscal;
	
	private String photo;
	
	private String webSite;
	
	@JsonIgnore
	private List<UtilisateurDto> utilisateurDto;
	
	
	public static EntrepriseDto fromEntity(Entreprise entre) {
		if( entre == null) {
			//TODO Throw Exception
			return null;
		}
		
		return EntrepriseDto.builder()
				.id(entre.getId())
				.name(entre.getName())
				.description(entre.getDescription())
				.adresse(AdressDto.fromEntity(entre.getAdress()))
				.codeFiscal(entre.getCodeFiscal())
				.photo(entre.getPhoto())
				.webSite(entre.getWebSite())
				.build();
	}
	
	public static Entreprise toEntity(EntrepriseDto dto) {
		
		Entreprise entre = new Entreprise();
		
		entre.setId(dto.getId());
		entre.setName(dto.getName());
		entre.setDescription(dto.getDescription());
		entre.setAdress(AdressDto.toEntity(dto.getAdresse()));
		entre.setCodeFiscal(dto.codeFiscal);
		entre.setPhoto(dto.getPhoto());
		entre.setWebSite(dto.getWebSite());
		
		return entre;
	}

}
