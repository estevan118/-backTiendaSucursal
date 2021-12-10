package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model.Products;


public interface ProductRepository extends MongoRepository<Products, String> {

	List<Products> findByCode(String code);
	
	List<Products> findByName(String name);
}