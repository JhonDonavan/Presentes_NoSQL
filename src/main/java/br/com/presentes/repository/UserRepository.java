package br.com.presentes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.presentes.models.Usuarios;

public interface UserRepository extends MongoRepository<Usuarios, String> {

	Usuarios findByUsername(String userId);

}
