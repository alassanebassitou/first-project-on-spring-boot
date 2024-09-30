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

import com.toure.project.dto.CommandeFournisseurDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/providerOrders")
public interface CommandeFournisseurApi {
	
	@PostMapping(value = APP_ROOT + "/commandeFournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to save or modify provider Order", description = "Create or modify provider Order")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful",
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeFournisseurDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto dto);
	
	@GetMapping(value = APP_ROOT + "/commandeFournisseur/find_id/{idComFour}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find one provider Order by ID", description = "Find provider Order by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The provider Order was found id DB",
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeFournisseurDto.class))),
	               @ApiResponse( responseCode = "400", description = "The provider Order was not found")
	})
	ResponseEntity<CommandeFournisseurDto> findById(@PathVariable("idComFour") Integer id);
	
	@GetMapping(value = APP_ROOT + "/commandeFournisseur/find_code/{codeComFour}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find provider Order by CODE", description = "This method allow to find one provider Order by CODE")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider Order was found id DB",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeFournisseurDto.class))),
			@ApiResponse( responseCode = "400", description = "The provider Order was not found")
	})
	ResponseEntity<CommandeFournisseurDto> findByCodeCom(@PathVariable("codeComFour")String code);
	
	@GetMapping(value = APP_ROOT + "/commandeFournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Retrieve all provider Orders", description = "THis method allow to retrieve all provider Orders")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The list is returned",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeFournisseurDto.class)))
	})
	ResponseEntity<List<CommandeFournisseurDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/commandeFournisseur/delete/{idComFour}")
	@Operation( summary = "Delete one provider Order by ID", description = "This method allow to delete one provider Order by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider Order is deleted",
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommandeFournisseurDto.class))),
			@ApiResponse( responseCode = "400", description = "The provider Order is not found")
	})
	void delete(@PathVariable("idComFour") Integer id);

}
