package co.edu.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.lagenerica.model.Consolidado;


public interface ConsolidadoRepository extends MongoRepository<Consolidado, String>{
	List<Consolidado> findByciudadContaining(String ciudad);
	
}