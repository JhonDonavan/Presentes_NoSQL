package br.com.presentes.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptorTest {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		String senha = "teste123";
		
		String senha2 = "1";
				
		System.out.println("Senha 'teste123' encriptografada é: " + bc.encode(senha2)); 
		
		System.out.println(bc.matches("1", bc.encode(senha2)));
		
		System.out.println(bc.upgradeEncoding(bc.encode(senha2)));

	}

}
