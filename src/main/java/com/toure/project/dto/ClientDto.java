package com.toure.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private AdressDto adresse;
	
	private Integer numTel;
	
	private String email;
	
	private String photo;

	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeClientDto> commandeClient;
	
	
	public static ClientDto fromEntity(Client client) {
		if(client == null) {
			//TODO Throw Exception			
			return null;
		}
		
		return ClientDto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.adresse(AdressDto.fromEntity(client.getAdresse()))
				.numTel(client.getNumTel())
				.email(client.getEmail())
				.photo(client.getPhoto())
				.idEntreprise(client.getIdEntreprise())
				.build();
	}
	
	
	public static Client toEntity(ClientDto dto) {
		
		Client cli = new Client();
		
		cli.setId(dto.getId());
		cli.setNom(dto.getNom());
		cli.setPrenom(dto.getPrenom());
		cli.setAdresse(AdressDto.toEntity(dto.getAdresse()));
		cli.setNumTel(dto.getNumTel());
		cli.setEmail(dto.getEmail());
		cli.setPhoto(dto.getPhoto());
		cli.setIdEntreprise(dto.getIdEntreprise());
		
		return cli;
	}

}
