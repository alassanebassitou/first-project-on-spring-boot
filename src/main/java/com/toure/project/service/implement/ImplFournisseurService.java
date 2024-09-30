package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.FournisseurDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Fournisseur;
import com.toure.project.repository.FournisseurRepository;
import com.toure.project.service.FournisseurService;
import com.toure.project.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ImplFournisseurService implements FournisseurService {
	
	private FournisseurRepository frnRepository;
	
	@Autowired
	public ImplFournisseurService(FournisseurRepository four) {
		this.frnRepository = four;
	}

	@Override
	public FournisseurDto save(FournisseurDto dto) {
		List<String> error = FournisseurValidator.validate(dto);
		
		if(!error.isEmpty()) {
			log.error("This Objet is invalide");
			throw new InvalidEntityException("", ErrorCodes.FOURNISSEUR_INVALID, error);
		}
		return FournisseurDto.fromEntity(frnRepository.save(FournisseurDto.toEntity(dto)));
	}

	@Override
	public FournisseurDto findById(Integer id) {
		
		if(id == null) {
			log.warn("THis ID is null {}", id);
			return null;
		}
		
		Optional<Fournisseur> four = frnRepository.findById(id);
		
		return Optional.of(
				FournisseurDto.fromEntity(four.get())
				).orElseThrow(() -> new EntityNotFoundException("", ErrorCodes.FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public FournisseurDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return frnRepository.findAll().stream()
				.map(FournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.warn("THis ID is null {}", id);
		}
		
		frnRepository.deleteById(id);

	}

}
