package com.toure.project.service.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.toure.project.dto.RoleDto;
import com.toure.project.dto.UtilisateurDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Role;
import com.toure.project.model.Utilisateur;
import com.toure.project.repository.RoleRepository;
import com.toure.project.repository.UtilisateurRepository;
import com.toure.project.service.UtilisateurService;
import com.toure.project.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplUtilisateurService implements UtilisateurService {
	
	//@Autowired
	private UtilisateurRepository useRepository;
	
//	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	public ImplUtilisateurService(UtilisateurRepository useRepo, RoleRepository roleRepository) {
		this.useRepository = useRepo;
		this.roleRepository = roleRepository;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		String roleName = "User";
		
		List<String> error = UtilisateurValidator.validate(dto);
		
		if(dto == null) {
			log.error("This object is invalid");
			throw new InvalidEntityException("This User object is invalid", ErrorCodes.UTILISATEUR_INVALIDE, error);
		}
		
		Role roleSeach = roleRepository.findByRolename(roleName)
				.orElseThrow(() -> new EntityNotFoundException("This role "+ roleName +" dont exist in ", ErrorCodes.ROLE_NOT_FOUND));
		
		Set<RoleDto> roles = new HashSet<>();
		roles.add(RoleDto.fromEntity(roleSeach));		
		dto.setRoles(roles);
				
		Utilisateur user = useRepository.save(UtilisateurDto.toEntity(dto));
		
		
		
		return UtilisateurDto.fromEntity(user);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		if(id == null) {
			log.warn("This ID is invalide",id);
			return null; 
		}
		
		
		return useRepository.findById(id)
				.map(UtilisateurDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("The object with email "+ id +"   not valid", ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDto findByEmail(String email) {
		//List<String> error = UtilisateurValidator.validate(null);
		if(!StringUtils.hasLength(email)) {
			log.warn("This email is invalide",email);
			throw new InvalidEntityException("The object with email "+ email +"   not valid", ErrorCodes.UTILISATEUR_INVALIDE); 
		}
		
		//Optional<Utilisateur> user = useRepository.findByEmail(email);
		
 		return useRepository.findByEmail(email)
				.map(UtilisateurDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("This user does not exist in the DB", ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public List<UtilisateurDto> findAll() {
		
		return useRepository.findAll().stream()
				.map(UtilisateurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if( id == null) {
			log.warn("ID is null");
		}
		useRepository.deleteById(id);
	}
	
//	private RoleDto findByRolename(String role) {
//		if(role == null) {
//			log.warn("Role is null");
//			return null;
//		}
//		
//				
//		return roleRepository.findByRolename(role)
//				.map(RoleDto::fromEntity)
//				.orElseThrow(()-> new EntityNotFoundException("Role dont exist in DataBase"));
//	}

}
