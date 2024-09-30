package com.toure.project.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.EntrepriseDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.repository.EntrepriseRepository;
import com.toure.project.service.EntrepriseService;
import com.toure.project.validator.EntrepriseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplEntrepriseService implements EntrepriseService {
	
	private EntrepriseRepository entrepoRepo;
	
	
	@Autowired
	public ImplEntrepriseService(EntrepriseRepository entrepoRepo) {
		super();
		this.entrepoRepo = entrepoRepo;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		List<String> error = EntrepriseValidator.validate(dto);
		if(error != null) {
			log.error("This object is not valid");
			throw new InvalidEntityException("This Entreprise object is not valid", ErrorCodes.ENTREPRISE_INVALID, error);
		}
		
		
		
		return null;
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if( id == null) {
			log.warn("ID is not valid");
			return null;
		}

		return entrepoRepo.findById(id).map(EntrepriseDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(""));
	}

	@Override
	public EntrepriseDto findByName(String name) {
		if( name == null) {
			log.warn("ID is not valid {}", name);
			return null;
		}

		return entrepoRepo.findByName(name)
				.map(EntrepriseDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException(""));
	}

	@Override
	public List<EntrepriseDto> findAll() {
		
		return entrepoRepo.findAll().stream()
				.map(EntrepriseDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
		if( id == null) {
			log.warn("ID is not valid");
		}
		

	}

}
