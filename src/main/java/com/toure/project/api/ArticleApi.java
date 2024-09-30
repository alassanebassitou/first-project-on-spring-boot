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

import com.toure.project.dto.ArticleDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = APP_ROOT + "/articles")
public interface ArticleApi {

	@PostMapping(value = APP_ROOT + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="This method allow to save aticle", description = "Create article")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The backup was successful", 
	            		   content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
	               @ApiResponse( responseCode = "400", description = "Tis objet is not valid")
	})
	ResponseEntity<ArticleDto> save(@RequestBody ArticleDto dto);
	
	@GetMapping(value = APP_ROOT + "/article/find_id/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This method allow to find one aticle by ID", description = "Find article by ID")
	@ApiResponses( value = {
	               @ApiResponse(responseCode = "200", description = "The article was found id DB",
	            		   content= @Content(mediaType = "application/json", schema= @Schema(implementation = ArticleDto.class))),
	               @ApiResponse( responseCode = "400", description = "The article was not found")
	})
	ResponseEntity<ArticleDto> findById(@PathVariable("idArticle") Integer id);
	
	@GetMapping(value = APP_ROOT + "/article/find_code/{codearticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation( summary = "Find article by CODE", description = "This method allow to find one aticle by CODE")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The article was found id DB",
         		   content= @Content(mediaType = "application/json", schema= @Schema(implementation = ArticleDto.class))),
			@ApiResponse( responseCode = "400", description = "The article was not found")
	})
	ResponseEntity<ArticleDto> findByCode(@PathVariable("codearticle") String code);
	
	@GetMapping(value = APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE )
	@Operation( summary = "Retrieve all articles", description = "THis method allow to retrieve all articles")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The list is returned",
         		   content= @Content(mediaType = "application/json", schema= @Schema(implementation = ArticleDto.class)))
	})
	ResponseEntity<List<ArticleDto>> findAll();
	
	@DeleteMapping(value = APP_ROOT + "/article/delete/{idarticle}")
	@Operation( summary = "Delete one article by ID", description = "This method allow to delete one article by his ID")
	@ApiResponses( value = {
			@ApiResponse( responseCode = "200", description = "The article is deleted",
	         		   content= @Content(mediaType = "application/json", schema= @Schema(implementation = ArticleDto.class))),
			@ApiResponse( responseCode = "400", description = "The article is not found")
	})
	void delete(@PathVariable("idarticle") Integer id);

}
