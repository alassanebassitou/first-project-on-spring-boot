package com.toure.project.service;

import com.toure.project.dto.RoleDto;

public interface RoleService {
	
	RoleDto save(RoleDto dto);
	
	RoleDto findById(Integer id);
	
	RoleDto findByRolename(String rolename);
	
	void deleteById(Integer id);

}
