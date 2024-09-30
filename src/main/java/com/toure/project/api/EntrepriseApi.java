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

import com.toure.project.dto.EntrepriseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/entreprises")
public interface EntrepriseApi {	

	@PostMapping(value = APP_ROOT + "/entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to save or modify a entreprise", description = "Create or modify a entreprise")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful",
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrepriseDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto dto);
	
	@GetMapping(value= APP_ROOT + "/entreprise/find_id/{identreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find a entreprise by ID", description = "Find a entreprise by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The entreprise was found id DB",
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrepriseDto.class))),
	               @ApiResponse( responseCode = "400", description = "The entreprise was not found")
	})
	ResponseEntity<EntrepriseDto> findById(@PathVariable("identreprise") Integer id);

	@GetMapping(value= APP_ROOT + "/entreprise/find_Name/{nomentreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find a entreprise by NAME", summary = "This method allow to find a entreprise by NAME")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The a entreprise was found id DB",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrepriseDto.class))),
			@ApiResponse( responseCode = "400", description = "The a entreprise was not found")
	})
	ResponseEntity<EntrepriseDto> findByCode(@PathVariable("nomentreprise") String nom);

	@GetMapping(value= APP_ROOT + "/entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Retrieve all entreprises", summary = "THis method allow to retrieve all entreprises")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The list is returned",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrepriseDto.class)))
	})
	ResponseEntity<List<EntrepriseDto>> findAll();
	
	@DeleteMapping(value= APP_ROOT + "/entreprise/delete/{identreprise}")
	@Operation( description = "Delete a entreprise by ID", summary = "This method allow to delete a entreprise by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The a entreprise is deleted",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntrepriseDto.class))),
			@ApiResponse( responseCode = "400", description = "The a entreprise is not found")
	})
	void delete(@PathVariable("identreprise") Integer id);

}
