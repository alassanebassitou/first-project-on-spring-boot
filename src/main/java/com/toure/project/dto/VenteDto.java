package com.toure.project.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Vente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenteDto {
	
	private Integer id;
	
	private String codeVente;
	
	private Instant dateVent;
	
	private String commentaire;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<LigneVenteDto> ligneVente;
	
	
	
	public static VenteDto fromEntity(Vente vente) {
		if (vente == null) {
			//TODO Throw Exception
			return null;
		}
		
		return VenteDto.builder()
				.id(vente.getId())
				.codeVente(vente.getCodeVent())
				.dateVent(vente.getDateVent())
				.commentaire(vente.getCommentaire())
				.idEntreprise(vente.getIdEntreprise())
				.build();
	}
	
	
	public static Vente toEntity(VenteDto dto) {
		
		Vente vente = new Vente();
		
		vente.setId(dto.getId());
		vente.setCodeVent(dto.getCodeVente());
		vente.setDateVent(dto.getDateVent());
		vente.setCommentaire(dto.getCommentaire());
		vente.setIdEntreprise(dto.getIdEntreprise());
		
		return vente;
	}

}
