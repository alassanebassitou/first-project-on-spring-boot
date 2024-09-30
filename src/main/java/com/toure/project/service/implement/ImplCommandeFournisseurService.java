package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.CommandeFournisseurDto;
import com.toure.project.dto.LigneCommandeFournisseurDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Article;
import com.toure.project.model.CommandeFournisseur;
import com.toure.project.model.Fournisseur;
import com.toure.project.model.LignCommandeFournisseur;
import com.toure.project.repository.ArticleRepository;
import com.toure.project.repository.CommandeFournisseurRepository;
import com.toure.project.repository.FournisseurRepository;
import com.toure.project.repository.LignCommandeFournisseurRepository;
import com.toure.project.service.CommandeFournisseurService;
import com.toure.project.validator.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplCommandeFournisseurService implements CommandeFournisseurService {
	
	private LignCommandeFournisseurRepository lignRepository;
	private FournisseurRepository fourRepository;
	private ArticleRepository articleRepository;
	private CommandeFournisseurRepository comRepository;
	
	@Autowired
	public ImplCommandeFournisseurService(LignCommandeFournisseurRepository lignRepository, FournisseurRepository fourRepository, 
			ArticleRepository articleRepository, CommandeFournisseurRepository comRepository) {
		this.articleRepository = articleRepository;this.comRepository = comRepository; this.fourRepository = fourRepository;
		this.lignRepository = lignRepository;
	}
	

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
		List<String> error = CommandeFournisseurValidator.validate(dto);
		if(!error.isEmpty()) {
			log.error("This object is invalid");
			throw new InvalidEntityException("The provider order is not valided", ErrorCodes.COMMANDE_FOURNISSEUR_INVALID, error);
		}
		
		Optional<Fournisseur> fournisseur = fourRepository.findById(dto.getFournisseur().getId());
		if(fournisseur.isEmpty()) {
			log.warn("This fournisseur object is null");
			throw new EntityNotFoundException("ID "+ dto.getFournisseur().getId()+" is not exist", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
		}
		
		if(dto.getLigneCommandeFournisseur() != null)
		{
			dto.getLigneCommandeFournisseur().forEach(lignFour ->{
				Optional<Article> article = articleRepository.findById(lignFour.getArticle().getId());
				if(article.isEmpty()) {
					log.warn("Article is not existed");
					throw new EntityNotFoundException("Article of ID "+ lignFour.getArticle().getId() +" is not found in the storage", ErrorCodes.ARTICLE_NOT_FOUND);
				}
			});
		}
		
		CommandeFournisseur comFournisseur = comRepository.save(CommandeFournisseurDto.toEntity(dto));
		if(dto.getLigneCommandeFournisseur() != null){
			dto.getLigneCommandeFournisseur().forEach(lignFour ->{
				
				LignCommandeFournisseur lign = LigneCommandeFournisseurDto.toEntity(lignFour);
				lign.setCommandeFournisseur(comFournisseur);
				lignRepository.save(lign);
			});
		}
		
		return CommandeFournisseurDto.fromEntity(comFournisseur);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id != null) {
			log.warn("ID is null");
			return null;
		}
		
		
		return comRepository.findById(id)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("This Entity is not found", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public CommandeFournisseurDto findByCodeCom(String code) {
		if(code.isEmpty()) {
			log.warn("This code is null");
			return null;
		}
		return comRepository.findByCodeCom(code)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("This Entity is not found", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		
		return comRepository.findAll().stream()
				.map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id != null) {
			log.warn("ID is null");
		}
		comRepository.deleteById(id);
	}

}
