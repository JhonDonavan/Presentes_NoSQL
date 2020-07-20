package br.com.presentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.presentes.assembler.PresenteModelAssembler;
import br.com.presentes.exceptions.PresenteNotFound;
import br.com.presentes.exceptions.differentPasswordsException;
import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;
import br.com.presentes.repository.PresentesRepository;

@Service
public class PresentesServiceImpl implements PresentesService {

	@Autowired
	PresentesRepository presenteRepository;
	
	@Autowired
	PresenteModelAssembler presenteModelAssembler;
	
	@Autowired
	Optional<Presente> presenteModel;

	@Override
	public List<PresenteModel> findAllPresentes() {
		List<Presente> allPresentes = presenteRepository.findAll();
		System.out.println(allPresentes.listIterator());
		return presenteModelAssembler.toHateoasPresenteModelCollections(allPresentes);
	}

	@Override
	public PresenteModel savePresente(Presente presente) {
		presenteRepository.save(presente);
		return presenteModelAssembler.toHateoasPresenteModel(presente);
	}

	@Override
	public void deletePresente(String id) throws PresenteNotFound {
		presenteRepository.findById(id).orElseThrow(() -> new PresenteNotFound(id));
		presenteRepository.deleteById(id);
	}

	@Override
	public PresenteModel findPresente(String id) {
		presenteModel = presenteRepository.findById(id);
		return null;
	}
}
