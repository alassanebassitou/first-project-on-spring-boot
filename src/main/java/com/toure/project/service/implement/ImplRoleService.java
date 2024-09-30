package com.toure.project.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.RoleDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.repository.RoleRepository;
import com.toure.project.service.RoleService;
import com.toure.project.validator.RoleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplRoleService implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleDto save(RoleDto dto) {
		List<String> error = RoleValidator.validate(dto);
		
		if(!error.isEmpty()) {
			log.error("This role you save is not valid");
			throw new InvalidEntityException("", ErrorCodes.ROLE_INVALID, error);
		}
		
		 //roleRepository.save(RoleDto.toEntity(dto));		
		
		
		return RoleDto.fromEntity(roleRepository.save(RoleDto.toEntity(dto)));
	}

	@Override
	public RoleDto findById(Integer id) {
		if(id == null) {
			log.warn("ID is null");
			return null;
		}
		
		
		return roleRepository.findById(id)
				.map(RoleDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("The role with ID: "+ id +" not found", ErrorCodes.ROLE_NOT_FOUND));
	}

	@Override
	public RoleDto findByRolename(String rolename) {
		if(rolename == null) {
			log.warn("Rolename is null");
			return null;
		}
		
		
		return roleRepository.findByRolename(rolename)
				.map(RoleDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("The role with ID: "+ rolename +" not found", ErrorCodes.ROLE_NOT_FOUND));
	}

	@Override
	public void deleteById(Integer id) {
		if(id == null) {
			log.warn("ID is null");
		}
		
		roleRepository.deleteById(id);
	}

}
