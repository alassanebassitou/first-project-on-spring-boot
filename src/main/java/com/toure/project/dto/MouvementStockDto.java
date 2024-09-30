package com.toure.project.dto;

import java.time.Instant;

import com.toure.project.model.MouvementStock;
import com.toure.project.model.TypeMouvement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MouvementStockDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	private Instant dateMouvement;
	
	private Integer quantity;

	private Integer idEntreprise;
	
	private TypeMouvement type;
	
	
	
	public static MouvementStockDto fromEntity(MouvementStock mvt) {
		if(mvt == null) {
			//TODO Throw Exception
			return null;
		}
		
		return MouvementStockDto.builder()
				.id(mvt.getId())
				.article(ArticleDto.fromEntity(mvt.getArticle()))
				.dateMouvement(mvt.getDateMouvement())
				.quantity(mvt.getQuantity())
				.idEntreprise(mvt.getIdEntreprise())
				.type(mvt.getTypeMouvement())
				.build();
	}
	
	
	public static MouvementStock toEntity(MouvementStockDto dto) {
		
		MouvementStock mvt = new MouvementStock();
		
		mvt.setId(dto.getId());
		mvt.setArticle(ArticleDto.toEntity(dto.getArticle()));
		mvt.setDateMouvement(dto.getDateMouvement());
		mvt.setQuantity(dto.getQuantity());
		mvt.setIdEntreprise(dto.getIdEntreprise());
		mvt.setTypeMouvement(dto.getType());
		
		return mvt;
	}

}
