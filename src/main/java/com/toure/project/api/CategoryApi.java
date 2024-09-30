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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= APP_ROOT + "/categories")
public interface CategoryApi {
	
	@PostMapping(value= APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
	@Operation(summary = "This method allow to save or modify category", description = "Create or modify category")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful", 
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto);
	
	@GetMapping(value = APP_ROOT + "/category/find_id/{idcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find one category by ID", description = "Find category by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The category was found id DB", 
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
	               @ApiResponse( responseCode = "400", description = "The category was not found")
	})
	ResponseEntity<CategoryDto> findById(@PathVariable("idcategory") Integer id);
	
	@GetMapping(value = APP_ROOT + "/category/find_code/{codecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find category by CODE", description = "This method allow to find one category by CODE")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The category was found id DB", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
			@ApiResponse( responseCode = "400", description = "The category was not found")
	})
	ResponseEntity<CategoryDto> findByCode(@PathVariable("codecategory") String code);
	
	@GetMapping(value= APP_ROOT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Retrieve all categories", description = "THis method allow to retrieve all categories")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The list is returned", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class)))
	})
	ResponseEntity<List<CategoryDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/category/delete")
	@Operation( summary = "Delete one category by ID", description = "This method allow to delete one category by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The category is deleted", 
         		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
			@ApiResponse( responseCode = "400", description = "The category is not found")
	})
	void delete(Integer id);

}
