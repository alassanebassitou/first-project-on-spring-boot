package com.toure.project.dto;

import com.toure.project.model.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	
	private Integer id;
	
	private ArticleDto articleVendu;
	
	private Integer quantityVendu;

	private Integer idEntreprise;
	
	private VenteDto vente;
	
	
	public static LigneVenteDto fromEntity(LigneVente ligne) {
		if(ligne == null) {
			//TODO Throw Exception
			return null;
		}
		
		return LigneVenteDto.builder()
				.id(ligne.getId())
				.articleVendu(ArticleDto.fromEntity(ligne.getArticleVendu()))
				.quantityVendu(ligne.getQuantiteVendu())
				.idEntreprise(ligne.getIdEntreprise())
				.vente(VenteDto.fromEntity(ligne.getVente()))
				.build();
	}
	
	
	public static LigneVente toEntity(LigneVenteDto dto) {
		
		LigneVente ligne = new LigneVente();
		
		ligne.setId(dto.getId());
		ligne.setArticleVendu(ArticleDto.toEntity(dto.getArticleVendu()));
		ligne.setQuantiteVendu(dto.getQuantityVendu());
		ligne.setIdEntreprise(dto.getIdEntreprise());
		ligne.setVente(VenteDto.toEntity(dto.getVente()));
		
		
		return ligne;
	}

}
