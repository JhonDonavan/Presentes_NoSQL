package br.com.presentes.exceptions;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter @Setter @RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4895631850657289041L;
	
	
	
	@NonNull
	private String id;
	private String message;

}
