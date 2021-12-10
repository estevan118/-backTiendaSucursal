package co.edu.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.lagenerica.model.Consolidated;

public interface ConsolidatedRepository extends MongoRepository<Consolidated, String>{

	List<Consolidated> findBycity(String city);
}