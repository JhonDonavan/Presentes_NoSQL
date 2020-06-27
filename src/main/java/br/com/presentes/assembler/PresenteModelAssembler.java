package br.com.presentes.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;

@Component
public class PresenteModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public PresenteModel toHateoasPresenteModel(Presente presente) {
		PresenteModel presenteModel = toModel(presente);

		//TODO DESENVOLVER LÓGICA PARA ADD LINKS ASSOCIADOS. HATEOAS!!
		
		return presenteModel;
	}
	
	public List<PresenteModel> toHateoasPresenteModelCollections(List<Presente> presentes){
		 List<PresenteModel> CollectionsPresenteModel = toCollectionModel(presentes);
		 
		//TODO DESENVOLVER LÓGICA PARA ADD LINKS ASSOCIADOS. HATEOAS!!
		 
		 return CollectionsPresenteModel;
	}


	private List<PresenteModel> toCollectionModel(List<Presente> presentes) {
		return presentes.stream().map(presente -> toModel(presente)).collect(Collectors.toList());
	}

	private PresenteModel toModel(Presente presente) {
		// TODO Auto-generated method stub
		PresenteModel pm =  modelMapper.map(presente, PresenteModel.class);
		
		return pm;
	}
	
}
