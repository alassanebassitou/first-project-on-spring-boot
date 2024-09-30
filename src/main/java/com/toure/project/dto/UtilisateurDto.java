package com.toure.project.dto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private AdressDto adresse;
	
	private Integer numTel;
	
	private String email;
	
	private String motDePasse;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	
	private String photo;
	
	//@JsonIgnore
	//private EntrepriseDto entreprise;
	
	@JsonIgnore
	private Set<RoleDto> roles;
	
	
	
	public static UtilisateurDto fromEntity(Utilisateur user) {
		
		if(user == null) {
			//TODO Throw Exception
			return null;
		}
		
		return UtilisateurDto.builder()
				.id(user.getId())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.adresse(AdressDto.fromEntity(user.getAdresse()))
				.numTel(user.getNumTel())
				.email(user.getEmail())
				.motDePasse(user.getMotPass())
				.dateNaissance(user.getDateNaissance())
				.photo(user.getPhoto())
				//.entreprise(EntrepriseDto.fromEntity(user.getEntreprise()))
				.roles(
						user.getRoles().stream()
						.map(RoleDto::fromEntity).collect(Collectors.toSet())
						)
				.build();
	}
	
	
	public static Utilisateur toEntity(UtilisateurDto dto) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Utilisateur user = new Utilisateur();
		user.setId(dto.getId());
		user.setNom(dto.getNom());
		user.setPrenom(dto.getPrenom());
		user.setAdresse(AdressDto.toEntity(dto.getAdresse()));
		user.setNumTel(dto.getNumTel());
		user.setEmail(dto.getEmail());
		user.setMotPass(passwordEncoder.encode(dto.getMotDePasse()));
		user.setPhoto(dto.getPhoto());
		user.setRoles(
				dto.getRoles().stream()
				.map(RoleDto::toEntity)
				.collect(Collectors.toSet())
				);
		//user.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));
		
		return user;
	}

}
