package com.toure.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toure.project.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	@Query("select r from Role r where r.rolename = :rolename")
	Optional<Role> findByRolename(String rolename);

}
