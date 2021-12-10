package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model.Sales;


public interface SaleRepository extends MongoRepository<Sales, String> {

	List<Sales> findBysalecode(Long salecode);
	List<Sales> findByidentification(Long identification);
	
	
	void deleteBysalecode(Long salecode);
	void deleteByidentification(Long identification);
}