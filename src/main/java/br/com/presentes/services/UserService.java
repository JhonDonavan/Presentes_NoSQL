package br.com.presentes.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.presentes.models.Usuarios;

public interface UserService {
	
	public UserDetails loadUserByUsername(String userId);
	
	//private List getAuthority();
	
	public List<Usuarios> findAll();
}
