package com.toure.project.configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.apis.FlickrApi.FlickrPerm;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

@Configuration
public class FlickrConfig {
	
	@Value("${flickr.apiKey}")
	private String apiKey;
	
	@Value("${flickr.apiSecret}")
	private String apiSecret;
	
	@Value("${flickr.appKey}")
	private String appKey;
	
	@Value("${flickr.appSecret}")
	private String appSecret;
	
	/**
	@Bean
	public Flickr getFlickr() throws IOException, InterruptedException, ExecutionException, FlickrException{
		
		Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
		OAuth10aService service = new ServiceBuilder(apiKey)
				.apiSecret(apiSecret)
				.build(FlickrApi.instance(FlickrPerm.DELETE));
		
		final Scanner scanner = new Scanner(System.in);
		final OAuth1RequestToken request = service.getRequestToken();
		final String authUrl = service.getAuthorizationUrl(request);
		
		System.out.println(authUrl);
		System.out.println("Past it here >> ");
		
		final String authVerifier = scanner.nextLine();
		
		OAuth1AccessToken accessTocken = service.getAccessToken(request, authVerifier);
		System.out.println(accessTocken.getToken());
		System.out.println(accessTocken.getTokenSecret());
		
		Auth auth = flickr.getAuthInterface().checkToken(accessTocken);
		
		System.out.println("===========================");
		System.out.println(auth.getToken());
		System.out.println(auth.getTokenSecret());
		
		return flickr;
	}*/
	
	
	@Bean
	public Flickr getFlickr() {
		
		Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
		
		Auth auth = new Auth();
		
		auth.setPermission(Permission.DELETE);
		auth.setToken(apiKey);
		auth.setTokenSecret(apiSecret);
		
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		
		flickr.setAuth(auth);
		
		return flickr;
	}

}
