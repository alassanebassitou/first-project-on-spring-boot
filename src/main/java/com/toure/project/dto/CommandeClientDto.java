package com.toure.project.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	
	private Integer id;
	
	private String codeCom;
	
	private Instant dateCommande;
	
	private ClientDto client;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<LigneCommandeClientDto> ligneCommandeClient;
	
	
	public static CommandeClientDto fromEntity(CommandeClient commande) {
		if(commande == null) {
			//TODO Throw Exception
			return null;
		}
		
		
		return CommandeClientDto.builder()
				.id(commande.getId())
				.codeCom(commande.getCodeCom())
				.dateCommande(commande.getDateCommande())
				.client(ClientDto.fromEntity(commande.getClient()))
				.idEntreprise(commande.getIdEntreprise())
				.build();
	}
	
	
	public static CommandeClient toEntity(CommandeClientDto dto) {
		
		CommandeClient comCli = new CommandeClient();
		
		comCli.setId(dto.getId());
		comCli.setCodeCom(dto.getCodeCom());
		comCli.setDateCommande(dto.getDateCommande());
		comCli.setClient(ClientDto.toEntity(dto.getClient()));
		comCli.setIdEntreprise(dto.getIdEntreprise());

		
		return comCli;
	}

}
