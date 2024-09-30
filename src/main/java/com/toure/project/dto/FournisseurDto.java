package com.toure.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private AdressDto adresse;
	
	private Integer numTel;
	
	private String email;
	
	private String photo;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeFournisseurDto> dtoFournisseur;
	
	
	public static FournisseurDto fromEntity(Fournisseur four) {
		
		if(four == null) {
			//TODO Throw Exception
			return null;
		}
		
		return FournisseurDto.builder()
				.id(four.getId())
				.nom(four.getNom())
				.prenom(four.getPrenom())
				.adresse(AdressDto.fromEntity(four.getAdresse()))
				.numTel(four.getNumTel())
				.email(four.getEmail())
				.photo(four.getPhoto())
				.idEntreprise(four.getIdEntreprise())
				.build();
	}
	
	
	public static Fournisseur toEntity(FournisseurDto dto) {
		
		Fournisseur fourn = new Fournisseur();
		
		fourn.setId(dto.getId());
		fourn.setNom(dto.getNom());
		fourn.setPrenom(dto.getPrenom());
		fourn.setAdresse(AdressDto.toEntity(dto.getAdresse()));
		fourn.setNumTel(dto.getNumTel());
		fourn.setEmail(dto.getEmail());
		fourn.setPhoto(dto.getPhoto());
		fourn.setIdEntreprise(dto.getIdEntreprise());
		
		return fourn;
	}


}
