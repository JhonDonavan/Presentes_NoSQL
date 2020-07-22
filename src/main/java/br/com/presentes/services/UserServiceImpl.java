package br.com.presentes.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.presentes.exceptions.UserNotFoundException;
import br.com.presentes.exceptions.differentPasswordsException;
import br.com.presentes.models.Presente;
import br.com.presentes.models.Usuarios;
import br.com.presentes.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRepository userRepository;
		
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Usuarios user = userRepository.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Usuarios> findAll() {
		return userRepository.findAll();
	}
	

	@Override
	public Usuarios save(Usuarios user) {
			
		if(!user.getPassword().toString().equals(user.getPasswordVerification().toString())) {
			throw new differentPasswordsException(user.getUserName().toString());
		}
				
		user.setPassword(encriptor(user.getPassword()));
		
		return userRepository.save(user);
	}
		
	public static String encriptor(String password) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		return bc.encode(password);
	}
	
	
	
	//TODO Criar dois controller user -- 1 para tratar login, cadastro perfil e outro para tratar da manutenção de presentes do usuario
	

	@Override
	public Usuarios UpdateUser(Long id, Usuarios user) {
		
		//TODO alterar para ID para STRING? avaliar!!
		Usuarios usuario = userRepository.findById(id.toString()).orElseThrow(() -> new UserNotFoundException(id.toString()));
	
		if(usuario.getPresentes() == null) { usuario.setPresentes(Arrays.asList()); }
		
		Usuarios saveUsuario = userRepository.save(usuario);
		//todo incluir hateoas
		return saveUsuario;
	}
}
