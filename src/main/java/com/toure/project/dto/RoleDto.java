package com.toure.project.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toure.project.model.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {
	
	private Integer id;
	
	private String rolename;

	private Integer idEntreprise;
	
	@JsonIgnore
	private Set<UtilisateurDto> utilisateur;
	
	
	public static RoleDto fromEntity(Role role) {
		if(role == null) {
			//TODO Throw Exception
			return null;
		}
		
		return RoleDto.builder()
				.id(role.getId())
				.rolename(role.getRolename())
				.idEntreprise(role.getIdEntreprise())
				.utilisateur(
						role.getUtilisateur().stream()
						.map(UtilisateurDto::fromEntity)
						.collect(Collectors.toSet())
						)
				.build();		
	}	
	
	
	public static Role toEntity(RoleDto dto) {
		
		Role role = new Role();
		
		role.setId(dto.getId());
		role.setRolename(dto.getRolename());
		role.setIdEntreprise(dto.getIdEntreprise());
		role.setUtilisateur(
				dto.getUtilisateur().stream()
				.map(UtilisateurDto::toEntity)
				.collect(Collectors.toSet())
				);
		
		return role;
	}

}
