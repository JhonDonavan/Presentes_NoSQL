package br.com.presentes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.presentes.assembler.PresenteModelAssembler;
import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;
import br.com.presentes.repository.PresentesRepository;

@Service
public class PresentesServiceImpl implements PresentesService {

	@Autowired
	PresentesRepository presenteRepository;
	
	@Autowired
	PresenteModelAssembler presenteModelAssembler;

	@Override
	public List<PresenteModel> findAllPresentes() {
		List<Presente> allPresentes = presenteRepository.findAll();
		System.out.println(allPresentes.listIterator());
		//return planetAssembler.toHateoasPlanetModelCollection(allPlanets);
		return presenteModelAssembler.toHateoasPresenteModelCollections(allPresentes);
	}

	@Override
	public PresenteModel savePlanet(Presente presente) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
}
