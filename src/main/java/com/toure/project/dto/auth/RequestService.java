package com.toure.project.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class RequestService {
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;

}
