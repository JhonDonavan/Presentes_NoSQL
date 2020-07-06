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

//@Api("API REST Presentes")
@RestController
@RequestMapping("/api")
public class PresentesController {

	@Autowired
	PresentesService presentesService;

//	@ApiOperation(value = "Busca todos os presentes")
	@GetMapping("/presentes")
	public ResponseEntity<List<PresenteModel>> getAllPresentes() {

		return ResponseEntity.status(HttpStatus.OK).body(presentesService.findAllPresentes());
	}

//	@ApiOperation(value = "Cadastrar um presente.")
	@PostMapping("/")
	public ResponseEntity<PresenteModel> createPlanet(@RequestBody Presente presente) {
		// return
		// ResponseEntity.status(HttpStatus.CREATED).body(presentesService.savePresente(presente));
		return null;
	}

}
