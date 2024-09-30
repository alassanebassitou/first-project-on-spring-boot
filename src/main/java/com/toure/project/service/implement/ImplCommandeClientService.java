package com.toure.project.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toure.project.dto.CommandeClientDto;
import com.toure.project.dto.LigneCommandeClientDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.exception.InvalidEntityException;
import com.toure.project.model.Article;
import com.toure.project.model.Client;
import com.toure.project.model.CommandeClient;
import com.toure.project.model.LignCommandeClient;
import com.toure.project.repository.ArticleRepository;
import com.toure.project.repository.ClientRepository;
import com.toure.project.repository.CommandeClientRepository;
import com.toure.project.repository.LignCommandeClientRepository;
import com.toure.project.service.CommandeClientService;
import com.toure.project.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplCommandeClientService implements CommandeClientService {
	
	private ArticleRepository articleRepository;
	private ClientRepository clientRepository;
	private CommandeClientRepository comCliRepository;
	private LignCommandeClientRepository lignRepository;
	
	@Autowired
	public ImplCommandeClientService(ArticleRepository articleRepository, ClientRepository clientRepository,
			CommandeClientRepository comCliRepository, LignCommandeClientRepository lignRepository) {
		this.articleRepository = articleRepository;
		this.clientRepository = clientRepository;
		this.comCliRepository = comCliRepository;
		this.lignRepository = lignRepository;
	}


	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		List<String> error = CommandeClientValidator.validate(dto);
		if(!error.isEmpty()) {
			log.error("This object is invalide");
			throw new InvalidEntityException("", ErrorCodes.COMMANDE_CLIENT_INVALID, error);
		}
		
		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
		if(client.isEmpty()) {
			log.warn("This order have not a costumer ID {}", dto.getClient().getId());
			throw new EntityNotFoundException("The costumer is not found", ErrorCodes.CLIENT_NOT_FOUND);
		}
		
		if(dto.getLigneCommandeClient() != null) {
			dto.getLigneCommandeClient().forEach(lgComCli ->{
				Optional<Article> article = articleRepository.findById(lgComCli.getArticle().getId());
				if(article.isEmpty()) {
					log.warn("This article is not exists");
					throw new InvalidEntityException("This article is not exist in database", ErrorCodes.ARTICLE_INVALID);
				}
			});
		}
		
		CommandeClient comClient = comCliRepository.save(CommandeClientDto.toEntity(dto));
		if(dto.getLigneCommandeClient() != null) {
			dto.getLigneCommandeClient().forEach(lgComCli ->{
				LignCommandeClient lign = LigneCommandeClientDto.toEntity(lgComCli);
				lign.setCommandeClient(comClient);
				lignRepository.save(lign);
			});
		}
		
		
		return CommandeClientDto.fromEntity(comClient);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id == null) {
			log.warn("This order have not a costumer ID {}", id);
			return null;
		}
		
		return comCliRepository.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCodeCom(String code) {
		if(code.isEmpty()) {
			log.warn("This order have not a costumer ID {}", code);
			return null;
		}
		
		return comCliRepository.findByCodeCom(code)
						.map(CommandeClientDto::fromEntity)
						.orElseThrow(()-> new EntityNotFoundException("", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		
		return comCliRepository.findAll().stream()
				.map(CommandeClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.warn("This order have not a costumer ID {}", id);
		}
		comCliRepository.deleteById(id);
	}

}
