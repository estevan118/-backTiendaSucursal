package co.edu.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.lagenerica.model.Client;



public interface ClientRepository extends MongoRepository<Client, String> {

	List<Client> findByidentification(Long identification);
	List<Client> findByname(String name);
	List<Client> findByemail(String email);
	
	
	void deleteByidentification(Long identification);
	void deleteByname(String name);
	void deleteByemail(String email);
}