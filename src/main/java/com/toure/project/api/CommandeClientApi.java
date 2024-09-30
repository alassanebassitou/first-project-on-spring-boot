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

import com.toure.project.dto.CommandeClientDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name =APP_ROOT + "/costumerOders")
public interface CommandeClientApi {
	
	@PostMapping(value = APP_ROOT + "/commandeClient/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to save or modify costumer Order", description = "Create or modify costumer Order")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful", 
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeClientDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);
	
	@GetMapping(value = APP_ROOT + "/commandeClient/find_id/{idcommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find one costumer Order by ID", description = "Find costumer Order by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The costumer Order was found id DB", 
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeClientDto.class))),
	               @ApiResponse( responseCode = "400", description = "The costumer Order was not found")
	})
	ResponseEntity<CommandeClientDto> findById(@PathVariable("idcommandeClient")  Integer id);
	
	@GetMapping(value = APP_ROOT + "/commandeClient/find_code/{codecommandeClient}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find costumer Order by CODE", description = "This method allow to find one costumer Order by CODE")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumer Order was found id DB", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeClientDto.class))),
			@ApiResponse( responseCode = "400", description = "The costumer Order was not found")
	})
	ResponseEntity<CommandeClientDto> findByCodeCom(@PathVariable("codecommandeClient") String code);
	
	@GetMapping(value = APP_ROOT + "/commandeClient/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Retrieve all costumers Orders", description = "THis method allow to retrieve all costumers Orders")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The list is returned", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeClientDto.class)))
	})
	ResponseEntity<List<CommandeClientDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/commandeClient/delete/{idcommandeClient}")
	@Operation( summary = "Delete one costumer Order by ID", description = "This method allow to delete one costumer Order by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The costumer Order is deleted", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeClientDto.class))),
			@ApiResponse( responseCode = "400", description = "The costumer Order is not found")
	})
	void delete(@PathVariable("idcommandeClient") Integer id);

}
