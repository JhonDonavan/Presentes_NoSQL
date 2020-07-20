package br.com.presentes.services;

import java.util.List;

import br.com.presentes.exceptions.PresenteNotFound;
import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;

public interface PresentesService {

	List<PresenteModel> findAllPresentes();
	
	PresenteModel savePresente(Presente presente);

	void deletePresente(String id) throws PresenteNotFound;

	PresenteModel findPresente(String id);
	
}
