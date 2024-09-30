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

import com.toure.project.dto.CategoryDto;
import com.toure.project.dto.ClientDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/costumers")
public interface ClientApi {
	
	@PostMapping(value = APP_ROOT + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Save or modify the costumer objet", description = "This method allow to save or modify one costumer objet")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The backup was successful", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))),
			@ApiResponse( responseCode = "400", description = "Backup failed")
	})
	ResponseEntity<ClientDto> save(@RequestBody ClientDto dto);
	
	@GetMapping(value = APP_ROOT + "/client/find_id/{idclient}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find one costumer by his ID", description = "This method allow to find one costumer by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumer exists", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
			@ApiResponse( responseCode = "400", description = "Costumer is not found")
	})
	ResponseEntity<ClientDto> findById(@PathVariable("idclient") Integer id);
	

	@GetMapping(value = APP_ROOT + "/client/find_email/{emailclient}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find one costumer by his EMAIL", description = "This method allow to find one costumer by his EMAIL")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumer exists", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))),
			@ApiResponse( responseCode = "400", description = "Costumer is not found")
	})
	ResponseEntity<ClientDto> findByEmail(@PathVariable("emailclient") String email);
	

	@GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Retrieve all costumer", description = "This method allow to retrieve all costumer")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumers list is retrieved", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class)))
	})
	ResponseEntity<List<ClientDto>> findAll();
	

	@DeleteMapping(value = APP_ROOT + "/client/{idclient}")
	@Operation( summary = "Delete one costumer by his ID", description = "This method allow to delete one costumer by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumer is successfully deleted", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))),
			@ApiResponse( responseCode = "400", description = "Deletion failed")
	})
	void delete(@PathVariable("idclient") Integer id);

}
