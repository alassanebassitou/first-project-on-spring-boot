package com.toure.project.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.toure.project.dto.RoleDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import static com.toure.project.utils.Constants.APP_ROOT;

@Tag(name = APP_ROOT + "/roles")
public interface RoleApi {
	
	@PostMapping(value = "/role/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description = "Save or modify a role", summary = "This method allow to save or modify role")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description="Backup or modify successful", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleDto.class))),
			@ApiResponse(responseCode = "400", description="Backup or modify failed")			
	})
	ResponseEntity<RoleDto> save(@RequestBody RoleDto dto);
	
	@GetMapping(value = "/role/find_id/{idrole}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description="Seach a role by Id", summary=" This method seach a role by Id" )
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description="Seach successful", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleDto.class))),
			@ApiResponse(responseCode = "400", description="Seach failed")			
	})
	ResponseEntity<RoleDto> findById(@PathVariable("idrole") Integer id);
	
	@GetMapping(value = "/role/find_name/{rolename}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description = "Seach a role by rolename", summary=" This method seach a role by rolename" )
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description="Seach successful", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleDto.class))),
			@ApiResponse(responseCode = "400", description="Seach failed")			
	})
	ResponseEntity<RoleDto> findByRolename(@PathVariable("rolename") String rolename);
	
	@DeleteMapping(value="/role/delete/{idrole}")
	@Operation(description = "Delete a role by id", summary=" This method delete a role by id" )
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description="Delete successful", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleDto.class))),
			@ApiResponse(responseCode = "400", description="Delete failed")			
	})
	void deleteById(@PathVariable("idrole") Integer id);

}
