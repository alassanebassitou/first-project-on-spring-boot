package com.toure.project.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Article;
import com.toure.project.model.LignCommandeClient;
import com.toure.project.model.LignCommandeFournisseur;
import com.toure.project.model.LigneVente;
import com.toure.project.model.MouvementStock;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
	
	private Integer id;
	
	private String code;
	
	private String designation;
	
	private BigDecimal prixHT;
	
	private BigDecimal tauxTVA;
	
	private BigDecimal prixTTC;
	
	private String photo;	

	private Integer idEntreprise;

	@JsonIgnore
	private CategoryDto category;
	
	@JsonIgnore
	private List<LignCommandeClient> lignCommandeClient;
	
	@JsonIgnore
	private List<LignCommandeFournisseur> lignCommandeFournisseur;
	
	@JsonIgnore
	private List<LigneVente> ligneVente;
	
	@JsonIgnore
	private List<MouvementStock> mouvementStock;
	
	public static ArticleDto fromEntity(Article article) {
		if(article == null) {
			//TODO throw exception
			return null;
		}
		return ArticleDto.builder()
				.id(article.getId())
				.code(article.getCode())
				.designation(article.getDesignation())
				.prixHT(article.getPrixHT())
				.tauxTVA(article.getTauxTVA())
				.prixTTC(article.getPrixTTC())
				.photo(article.getPhoto())
				.idEntreprise(article.getIdEntreprise())
				.category(CategoryDto.fromEntity(article.getCategory()))
				.build();
	}
	
	public static Article toEntity(ArticleDto dto) {
		
		Article art = new Article();
		
		art.setId(dto.getId());
		art.setCode(dto.getCode());
		art.setDesignation(dto.getDesignation());
		art.setPrixHT(dto.getPrixHT());
		art.setTauxTVA(dto.getTauxTVA());
		art.setPrixTTC(dto.getPrixTTC());
		art.setPhoto(dto.getPhoto());
		art.setIdEntreprise(dto.getIdEntreprise());
		art.setCategory(CategoryDto.toEntity(dto.getCategory()));
		
		return art;
	}

}
