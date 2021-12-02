package co.edu.lagenerica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.lagenerica.model.Cliente;


public interface TutorialRepository extends MongoRepository<Cliente,String>{
	List<Cliente> findBycedulaContaining(String cedula);
	Optional<Cliente> findById(String cedula);
}
