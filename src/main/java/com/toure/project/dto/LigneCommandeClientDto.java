package com.toure.project.dto;

import com.toure.project.model.LignCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {
	
	private Integer id;
	
	private ArticleDto article;
	
	private Integer quantityCommande;

	private Integer idEntreprise;
	
	private CommandeClientDto commandeClient;
	
	
	public static LigneCommandeClientDto fromEntity(LignCommandeClient ligne) {
		if(ligne == null) {
			//TODO Throw Exception
			return null;
		}
		
		return LigneCommandeClientDto.builder()
				.id(ligne.getId())
				.article(ArticleDto.fromEntity(ligne.getArticleCommande()))
				.quantityCommande(ligne.getQuantiteCommande())
				.idEntreprise(ligne.getIdEntreprise())
				.commandeClient(CommandeClientDto.fromEntity(ligne.getCommandeClient()))
				.build();
	}
	
	
	public static LignCommandeClient toEntity(LigneCommandeClientDto dto) {
		
		LignCommandeClient comCli = new LignCommandeClient();
		
		comCli.setId(dto.getId());
		comCli.setArticleCommande(ArticleDto.toEntity(dto.getArticle()));
		comCli.setQuantiteCommande(dto.getQuantityCommande());
		comCli.setIdEntreprise(dto.getIdEntreprise());
		comCli.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClient()));
		
		return comCli;
	}

}
