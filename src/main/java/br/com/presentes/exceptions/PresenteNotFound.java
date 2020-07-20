package br.com.presentes.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class PresenteNotFound extends NotFoundException {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 7225943922483255637L;
	
	
	@NonNull
	private String id;
	@SuppressWarnings("unused")
	private String message;
	
}
