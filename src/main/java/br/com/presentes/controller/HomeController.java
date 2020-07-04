package br.com.presentes.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.presentes.Utils.Constants;


@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
	public String Index() {
		return Constants.INDEX_VIEW;
	}

	@GetMapping(path = "hello/{name}")
	public ResponseEntity<String> sayHello(@PathVariable("name") String name) {
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/json")).body("Hello " + name);
	}

}
