package br.com.presentes.exceptions;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class differentPasswordsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7225943922483255637L;
	
	
	@NonNull
	private String id;
	private String message;

}
