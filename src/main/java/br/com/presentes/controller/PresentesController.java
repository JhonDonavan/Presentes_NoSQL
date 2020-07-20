package br.com.presentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.presentes.exceptions.PresenteNotFound;
import br.com.presentes.models.Presente;
import br.com.presentes.models.PresenteModel;
import br.com.presentes.services.PresentesService;

//@Api("API REST Presentes")
@RestController
@RequestMapping("/api")
public class PresentesController {

	@Autowired
	PresentesService presentesService;
	
	//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	//@ApiOperation(value = "Busca todos os presentes")
	@GetMapping("/presentes")
	public ResponseEntity<List<PresenteModel>> getAllPresentes() {
		return ResponseEntity.status(HttpStatus.OK).body(presentesService.findAllPresentes());
	}

	//@ApiOperation(value = "Cadastrar um presente.")
	@PostMapping("/presentes")
	public ResponseEntity<PresenteModel> createPresentes(@RequestBody Presente presente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(presentesService.savePresente(presente));
	}
	
	public ResponseEntity<PresenteModel> deletePresente(@Param(value = "id") String id) {
		try {
			presentesService.deletePresente(id);
		} catch (PresenteNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	public ResponseEntity<PresenteModel> find(@Param(value = "id") String id){
		return ResponseEntity.status(HttpStatus.OK).body(presentesService.findPresente(id));
	}

}
