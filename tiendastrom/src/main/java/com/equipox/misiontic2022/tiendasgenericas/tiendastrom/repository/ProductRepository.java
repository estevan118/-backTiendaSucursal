package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model.Products;


public interface ProductRepository extends MongoRepository<Products,String> {

}
