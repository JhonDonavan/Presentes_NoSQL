package br.com.presentes.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.presentes.models.Presente;

@Repository
public interface PresentesRepository extends MongoRepository<Presente, String> {

}
