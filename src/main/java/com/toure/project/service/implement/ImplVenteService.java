package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.LigneVenteDto;
import com.toure.project.dto.VenteDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Article;
import com.toure.project.model.LigneVente;
import com.toure.project.model.Vente;
import com.toure.project.repository.ArticleRepository;
import com.toure.project.repository.LignVenteRepository;
import com.toure.project.repository.VenteRepository;
import com.toure.project.service.VenteService;
import com.toure.project.validator.VenteValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplVenteService implements VenteService {
	
	private LignVenteRepository lignRepository;
	private VenteRepository venteRepository;
	private ArticleRepository articleRepository;
	
	@Autowired
	public ImplVenteService(LignVenteRepository lignRepo, VenteRepository venteRepo, ArticleRepository articleRepo) {
		this.articleRepository = articleRepo;
		this.lignRepository = lignRepo;
		this.venteRepository = venteRepo;
	}

	@Override
	public VenteDto save(VenteDto dto) {
		List<String> error = VenteValidator.validate(dto);
		
		if(!error.isEmpty()) {
			log.error("This entity is not valided");
			throw new InvalidEntityException("Invalid Entity", ErrorCodes.VENTE_INVALID, error);
		}
		
		if(dto.getLigneVente() != null) {
			dto.getLigneVente().forEach(lignV ->{
				Optional<Article> article = articleRepository.findById(lignV.getArticleVendu().getId());
				if(article.isEmpty()) {
					log.warn("Article is not found");
					throw new EntityNotFoundException("The article of ID "+ lignV.getArticleVendu().getId() +" is not found in DB", ErrorCodes.ARTICLE_NOT_FOUND);
				}
			});
		}
		
		Vente venteS = venteRepository.save(VenteDto.toEntity(dto));
		if(dto.getLigneVente() != null) {
			dto.getLigneVente().forEach(lignV ->{
				LigneVente vente = LigneVenteDto.toEntity(lignV);
				vente.setVente(venteS);
				lignRepository.save(vente);
			});
		}
		
		return VenteDto.fromEntity(venteS);
	}

	@Override
	public VenteDto findById(Integer id) {
		if( id == null) {
			log.warn("Id is null");
			return null;
		}
		return venteRepository.findById(id)
				.map(VenteDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("this entity is not exist in daatabase", ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public VenteDto findByCodeVent(String code) {
		if(code.isEmpty()) {
			log.warn("Code is null");
			return null;
		}
		return venteRepository.findByCodeVent(code)
				.map(VenteDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("this entity is not exist in database", ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public List<VenteDto> findAll() {
		
		return venteRepository.findAll().stream()
				.map(VenteDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if( id == null) {
			log.warn("Id is null");
		}
		venteRepository.deleteById(id);
	}

}
