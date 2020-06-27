package br.com.presentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;
import br.com.presentes.services.PresentesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("API REST Presentes")
@RestController
@RequestMapping("api/presentes")
public class PresentesController {
	
	@Autowired
	PresentesService presentesService;
	
	@ApiOperation(value = "Busca todos os presentes")
	@GetMapping("/")
	public ResponseEntity<List<PresenteModel>> getAllPresentes(){
		List<PresenteModel> presentesModel = presentesService.findAllPresentes();
		
		presentesModel.forEach(System.out::println);
		return ResponseEntity.status(HttpStatus.OK).body(presentesModel);
	}
	
	@ApiOperation(value = "Cadastrar um presente.")
	@PostMapping("/")
	public ResponseEntity<PresenteModel> createPlanet(@RequestBody Presente presente){
		//return ResponseEntity.status(HttpStatus.CREATED).body(presentesService.savePresente(presente));
		return null;
	}

}
