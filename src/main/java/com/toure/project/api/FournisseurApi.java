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

import com.toure.project.dto.FournisseurDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/providers")
public interface FournisseurApi {

	@PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Save or modify the provider objet", summary = "This method allow to save or modify one provider objet")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The backup was successful",
					content =@Content(mediaType = "application/json", schema =@Schema(implementation = FournisseurDto.class))),
			@ApiResponse( responseCode = "400", description = "Backup failed")
	})
	ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto dto);
	
	@GetMapping(value= APP_ROOT + "/fournisseur/find_id/{idfournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find one provider by his ID", summary = "This method allow to find one provider by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider exists",
					content =@Content(mediaType = "application/json", schema =@Schema(implementation = FournisseurDto.class))),
			@ApiResponse( responseCode = "400", description = "Provider is not found")
	})
	ResponseEntity<FournisseurDto> findById(@PathVariable("idfournisseur") Integer id);

	@GetMapping(value= APP_ROOT + "/fournisseur/find_code/{emailfournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find one provider by his EMAIL", summary = "This method allow to find one provider by his EMAIL")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider exists"),
			@ApiResponse( responseCode = "400", description = "Provider is not found")
	})
	ResponseEntity<FournisseurDto> findByEmail(@PathVariable("emailfournisseur") String email);

	@GetMapping(value= APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Retrieve all provider", summary = "This method allow to retrieve all provider")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider list is retrieved",
					content =@Content(mediaType = "application/json", schema =@Schema(implementation = FournisseurDto.class)))
	})
	ResponseEntity<List<FournisseurDto>> findAll();

	@DeleteMapping(value= APP_ROOT + "/fournisseur/delete/{idfournisseur}")
	@Operation( description = "Delete one provider by his ID", summary = "This method allow to delete one provider by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The provider is successfully deleted",
					content =@Content(mediaType = "application/json", schema =@Schema(implementation = FournisseurDto.class))),
			@ApiResponse( responseCode = "400", description = "Deletion failed")
	})
	void delete(@PathVariable("idfournisseur") Integer id);

}
