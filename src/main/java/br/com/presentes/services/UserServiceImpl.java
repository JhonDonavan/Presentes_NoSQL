package br.com.presentes.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.presentes.models.Usuarios;
import br.com.presentes.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;

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
		return userRepository.save(user);
	}

	
}
