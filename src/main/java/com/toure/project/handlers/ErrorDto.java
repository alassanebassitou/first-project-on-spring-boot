package com.toure.project.handlers;

import java.util.ArrayList;
import java.util.List;

import com.toure.project.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
	
	private Integer httpCode;
	
	private String message;
	
	private ErrorCodes code;
	
	private List<String> error = new ArrayList<>();

}
