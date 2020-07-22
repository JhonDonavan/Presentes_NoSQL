package br.com.presentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.presentes.models.Presente;
import br.com.presentes.models.Usuarios;
import br.com.presentes.services.UserService;
	
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<Usuarios> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Usuarios> create(@RequestBody Usuarios user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		//userService.delete(id);
		//return "success";
		return null;
	}
	
	public ResponseEntity<Usuarios> Update(@PathVariable(value="id") Long id,  @RequestBody Usuarios user){
		return ResponseEntity.status(HttpStatus.OK).body(userService.UpdateUser(id, user));
	}

}
