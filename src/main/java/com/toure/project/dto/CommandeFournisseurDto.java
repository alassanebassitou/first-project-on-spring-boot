package com.toure.project.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	
	private Integer id;
	
	private String code;
	
	private Instant dateCommande;

	private Integer idEntreprise;
	
	private FournisseurDto fournisseur;
	
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseur;
	
	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commande) {
		if(commande == null) {
			//TODO Throw Exception
			return null;
		}
		
		return CommandeFournisseurDto.builder()
				.id(commande.getId())
				.code(commande.getCodeCom())
				.dateCommande(commande.getDateCommande())
				.idEntreprise(commande.getIdEntreprise())
				.fournisseur(FournisseurDto.fromEntity(commande.getFournisseur()))
				.build();
	}
	
	
	public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
		
		CommandeFournisseur com = new CommandeFournisseur();
		
		com.setId(dto.getId());
		com.setCodeCom(dto.getCode());
		com.setIdEntreprise(dto.getIdEntreprise());
		com.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
		
		
		return com;
	}

}
