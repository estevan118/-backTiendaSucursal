package co.edu.lagenerica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.lagenerica.model.Proveedores;


public interface ProveedoresRepository extends MongoRepository<Proveedores,String> {
	
	List<Proveedores> findByNitproveedorContaining(String Nitproveedor);
	Optional<Proveedores>findById(String Nitproveedor);

}