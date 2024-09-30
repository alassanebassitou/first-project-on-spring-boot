package com.toure.project.configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.toure.project.dto.UtilisateurDto;
import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.ErrorCodes;
import com.toure.project.service.UtilisateurService;

@Component
public class UtilisateurDetailsService  implements UserDetailsService{
	
	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	public UtilisateurDetailsService(UtilisateurService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UtilisateurDto user = userService.findByEmail(username);
		if(user == null) {			
			throw new EntityNotFoundException("This user is not found", ErrorCodes.UTILISATEUR_NOT_FOUND);
		}
		
		Set<SimpleGrantedAuthority> auth = new HashSet<>();
		
		user.getRoles().forEach(role -> auth.add(new SimpleGrantedAuthority(role.getRolename())) );
		
		return new User(user.getEmail(), user.getMotDePasse(), auth);
	}

	/**@Bean
	public UserDetails userDetailsService() {		
		
		return username -> userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("The user is not found"));
	}*/

}
