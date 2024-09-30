package com.toure.project.api;

import static com.toure.project.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.toure.project.dto.UtilisateurDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/users")
public interface UtilisateurApi {

	@PostMapping(value = APP_ROOT + "/user/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Save or modify the user objet", summary = "This method allow to save or modify one user objet")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The backup was successful", 
					content =@Content(mediaType ="application/json", schema =@Schema(implementation = UtilisateurDto.class))),
			@ApiResponse( responseCode = "400", description = "Backup failed")
	})
	ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto dto);

	@GetMapping(value= APP_ROOT + "/user/find_id/{idutilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find one user by his ID", summary = "This method allow to find one user by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The user exists", 
					content =@Content(mediaType ="application/json", schema =@Schema(implementation = UtilisateurDto.class))),
			@ApiResponse( responseCode = "400", description = "User is not found")
	})
	ResponseEntity<UtilisateurDto> findById(@PathVariable("idutilisateur") Integer id);

	@GetMapping(value= APP_ROOT + "/user/find_email/{emailutilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find one user by his EMAIL", summary = "This method allow to find one user by his EMAIL")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The user exists", 
					content =@Content(mediaType ="application/json", schema =@Schema(implementation = UtilisateurDto.class))),
			@ApiResponse( responseCode = "400", description = "User is not found")
	})
	ResponseEntity<UtilisateurDto> findByEmail(@PathVariable("emailutilisateur") String email);

	@GetMapping(value= APP_ROOT + "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Retrieve all user", summary = "This method allow to retrieve all user")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The user list is retrieved", 
					content =@Content(mediaType ="application/json", schema =@Schema(implementation = UtilisateurDto.class)))
	})
	ResponseEntity<List<UtilisateurDto>> findAll();

	@DeleteMapping(value= APP_ROOT + "/user/delete/{idutilisateur}")
	@Operation( description = "Delete one user by his ID", summary = "This method allow to delete one user by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The user is successfully deleted", 
					content =@Content(mediaType ="application/json", schema =@Schema(implementation = UtilisateurDto.class))),
			@ApiResponse( responseCode = "400", description = "Deletion failed")
	})
	void delete(@PathVariable("idutilisateur") Integer id);

}
