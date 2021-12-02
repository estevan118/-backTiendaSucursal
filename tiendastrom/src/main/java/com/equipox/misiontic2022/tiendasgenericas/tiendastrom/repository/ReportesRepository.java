package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model.Reportes;



public interface ReportesRepository extends MongoRepository<Reportes,String> {
	List<Reportes> findBycedulaContaining(String cedula);
}
