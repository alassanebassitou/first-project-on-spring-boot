package com.toure.project.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.toure.project.api.RoleApi;
import com.toure.project.dto.RoleDto;
import com.toure.project.service.implement.ImplRoleService;

@RestController
public class RoleController implements RoleApi {
	
	@Autowired
	private ImplRoleService roleService;

	@Override
	public ResponseEntity<RoleDto> save(RoleDto dto) {	
		
		return ResponseEntity.ok(roleService.save(dto));
	}

	@Override
	public ResponseEntity<RoleDto> findById(Integer id) {
		
		return ResponseEntity.ok(roleService.findById(id));
	}

	@Override
	public ResponseEntity<RoleDto> findByRolename(String rolename) {
		
		return ResponseEntity.ok(roleService.findByRolename(rolename));
	}

	@Override
	public void deleteById(Integer id) {
		roleService.deleteById(id);

	}

}
