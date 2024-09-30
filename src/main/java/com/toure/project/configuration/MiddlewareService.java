package com.toure.project.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.toure.project.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MiddlewareService extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UtilisateurDetailsService userDetailsService;

	//@Bean
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authHeader = request.getHeader("Authorization");
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			final String jwt = authHeader.substring(7);
			final String username = jwtService.extractUsername(jwt);
			
			Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
			
			if(username != null && authenticate == null) {
				UserDetails user = this.userDetailsService.loadUserByUsername(username);
				
				if(jwtService.isTokenValid(jwt, user)) {
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
							user.getUsername(),
							null,
							user.getAuthorities()
							);
					token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(token);;
				}
				
			}
			
		}
		
		filterChain.doFilter(request, response);

	}

}
