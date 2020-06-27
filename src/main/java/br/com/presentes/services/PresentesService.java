package br.com.presentes.services;

import java.util.List;

import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;

public interface PresentesService {

	List<PresenteModel> findAllPresentes();
	
	PresenteModel savePlanet(Presente presente);
	
}
