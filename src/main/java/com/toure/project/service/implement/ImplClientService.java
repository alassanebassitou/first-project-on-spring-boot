package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.ClientDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Client;
import com.toure.project.repository.ClientRepository;
import com.toure.project.service.ClientService;
import com.toure.project.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplClientService implements ClientService {
	
	private ClientRepository cliRepo;
	
	@Autowired
	public ImplClientService(ClientRepository cliRe) {
		this.cliRepo = cliRe;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		List<String> error = ClientValidator.validate(dto);
		if(!error.isEmpty()) {
			log.error("This Object is null");
			throw new InvalidEntityException("", ErrorCodes.CLIENT_INVALID, error);
		}
		return ClientDto.fromEntity(cliRepo.save(ClientDto.toEntity(dto)));
	}

	@Override
	public ClientDto findById(Integer id) {
		if(id == null) {
			log.warn("This costumer ID is null {}",id);
			return null;
		}
		Optional<Client> client = cliRepo.findById(id);
		
		return Optional.of(
				ClientDto.fromEntity(client.get())
				).orElseThrow(()-> new EntityNotFoundException("The costumer with ID "+ id +" is not found in the storage", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return cliRepo.findAll().stream()
				.map(ClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.warn("This costumer ID is null {}",id);
		}
		
		cliRepo.deleteById(id);
	}

}
