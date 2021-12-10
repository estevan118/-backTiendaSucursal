package co.edu.lagenerica.controller;

import java.util.ArrayList;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.lagenerica.model.Proveedores;

import co.edu.lagenerica.repository.ProveedoresRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProveedoresController {

	@Autowired
	ProveedoresRepository proveedoresRepository;
	
	 @GetMapping("/Proveedores")
	  public ResponseEntity<List<Proveedores>> MostrarPorNit(@RequestParam(required = false) String Nitproveedor) {
		  try {
			    List<Proveedores> proveedor = new ArrayList<Proveedores>();

			    if (Nitproveedor == null)
			    	proveedoresRepository.findAll().forEach(proveedor::add);
			    else
			    	proveedoresRepository.findByNitproveedorContaining(Nitproveedor).forEach(proveedor::add);

			    if (proveedor.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(proveedor, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
      }
	 
	 @PostMapping("/CrearProveedores")
	  public ResponseEntity<Proveedores> CrearProveedor(@RequestBody Proveedores proveedor) {
		  try {
			    Proveedores proveedoresrepositorio= proveedoresRepository.save(new Proveedores(proveedor.getNitproveedor(),proveedor.getCiudad(),proveedor.getDireccion(),proveedor.getNombre(),proveedor.getTelefono()));
			    return new ResponseEntity<>(proveedoresrepositorio , HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	 
	 @PutMapping("/Proveedores/{Nitproveedor}")
	  public ResponseEntity<Proveedores> ActualizarProveedor(@PathVariable("Nitproveedor") String Nitproveedor, @RequestBody Proveedores tutorial){
		  Optional<Proveedores> tutorialData = proveedoresRepository.findById(Nitproveedor);
		  if (tutorialData.isPresent()) {
		    Proveedores _tutorial = tutorialData.get();
		    _tutorial.setCiudad(tutorial.getCiudad());
		    _tutorial.setDireccion(tutorial.getDireccion());
		    _tutorial.setNombre(tutorial.getNombre());
		    _tutorial.setTelefono(tutorial.getTelefono());
		    return new ResponseEntity<>(proveedoresRepository.save(_tutorial), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	 
	 @DeleteMapping("/ProveedoresEliminarNit/{Nitproveedor}")
	  public ResponseEntity<HttpStatus> BorrarPorNit(String Nitproveedor) {
		  try {
			  List<Proveedores> proveedor = new ArrayList<Proveedores>();
			  proveedoresRepository.findByNitproveedorContaining(Nitproveedor).forEach(proveedor::add);

			    if (proveedor.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			    proveedoresRepository.deleteAll(proveedor);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	 
	 @DeleteMapping("/Proveedores")
	  public ResponseEntity<HttpStatus> BorrarTodo() {
		  try {
			  proveedoresRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
}