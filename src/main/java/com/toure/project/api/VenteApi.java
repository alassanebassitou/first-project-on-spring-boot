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

import com.toure.project.dto.VenteDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/sales")
public interface VenteApi {

	@PostMapping(value = APP_ROOT + "/vente/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to save or modify a sale", description = "Create or modify a sale")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful",
	            		   content =@Content(mediaType = "application/json", schema =@Schema(implementation = VenteDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<VenteDto> save(@RequestBody VenteDto dto);

	@GetMapping(value = APP_ROOT + "/vente/find_id/{idvente}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find a sale by ID", description = "Find a sale by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode ="200", description = "The a sale was found id DB",
	            		   content =@Content(mediaType = "application/json", schema =@Schema(implementation = VenteDto.class))),
	               @ApiResponse( responseCode = "400", description = "The a sale was not found")
	})
	ResponseEntity<VenteDto> findById(@PathVariable("idvente") Integer id);

	@GetMapping(value = APP_ROOT + "/vente/find_code/{codevent}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Find a sale by CODE", summary = "This method allow to find a sale by CODE")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The a sale was found id DB",
         		   content =@Content(mediaType = "application/json", schema =@Schema(implementation = VenteDto.class))),
			@ApiResponse( responseCode = "400", description = "The a sale was not found")
	})
	ResponseEntity<VenteDto> findByCodeVent(@PathVariable("codevent") String code);

	@GetMapping(value = APP_ROOT + "/vente/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( description = "Retrieve all sales", summary = "THis method allow to retrieve all sales")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "400", description = "The list is returned",
         		   content =@Content(mediaType = "application/json", schema =@Schema(implementation = VenteDto.class)))
	})
	ResponseEntity<List<VenteDto>> findAll();

	@DeleteMapping(value = APP_ROOT + "/vente/delete/{idvente}")
	@Operation( description = "Delete a sale by ID", summary = "This method allow to delete a sale by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The a sale is deleted",
         		   content =@Content(mediaType = "application/json", schema =@Schema(implementation = VenteDto.class))),
			@ApiResponse( responseCode = "400", description = "The a sale is not found")
	})
	void delete(@PathVariable("idvente") Integer id);

}
