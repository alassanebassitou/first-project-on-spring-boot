package com.toure.project.dto;

import com.toure.project.model.LignCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	private Integer quantityFournis;

	private Integer idEntreprise;	
	
	private CommandeFournisseurDto commandeFournisseur;
	
	
	
	public static LigneCommandeFournisseurDto fromEntity(LignCommandeFournisseur ligne) {
		if(ligne == null) {
			//TODO Throw Exception
			
			return null;
		}
		
		
		return LigneCommandeFournisseurDto.builder()
				.id(ligne.getId())
				.article(ArticleDto.fromEntity(ligne.getArticleFournis()))
				.quantityFournis(ligne.getQuantiteFournisseur())
				.idEntreprise(ligne.getIdEntreprise())
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(ligne.getCommandeFournisseur()))
				.build();
	}
	
	public static LignCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto) {
		
		LignCommandeFournisseur four = new LignCommandeFournisseur();
		
		four.setId(dto.getId());
		four.setArticleFournis(ArticleDto.toEntity(dto.getArticle()));
		four.setQuantiteFournisseur(dto.getQuantityFournis());
		four.setIdEntreprise(dto.getIdEntreprise());
		four.setCommandeFournisseur(CommandeFournisseurDto.toEntity(dto.getCommandeFournisseur()));
		
		
		return four;
	}

}
