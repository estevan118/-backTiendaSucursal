package co.edu.lagenerica.controller;



import java.util.ArrayList;
import java.util.*;

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

import co.edu.lagenerica.model.Cliente;

import co.edu.lagenerica.repository.TutorialRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class TutorialController {

	
	@Autowired
	  TutorialRepository tutorialRepository;

	  @GetMapping("/Clientes")
	  public ResponseEntity<List<Cliente>> MostrarPorCedula(@RequestParam(required = false) String cedula) {
		  try {
			    List<Cliente> clientes = new ArrayList<Cliente>();

			    if (cedula == null)
			      tutorialRepository.findAll().forEach(clientes::add);
			    else
			      tutorialRepository.findBycedulaContaining(cedula).forEach(clientes::add);

			    if (clientes.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(clientes, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
  }
	
	  @GetMapping("/Clientes/{id}")
	  public ResponseEntity<Cliente> MostrarPorId(@PathVariable("id") String id) {
		  Optional<Cliente> tutorialData = tutorialRepository.findById(id);

		  if (tutorialData.isPresent()) {
		    return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @PostMapping("/Clientes")
	  public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente) {
		  try {
			    Cliente clienterepositorio= tutorialRepository.save(new Cliente(cliente.getCedula(), cliente.getDireccion_cliente(),cliente.getEmail_cliente(),cliente.getNombre_cliente(),cliente.getTelefono_cliente()));
			    return new ResponseEntity<>(clienterepositorio , HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/Clientes/{id}")
	  public ResponseEntity<Cliente> ActualizarClienteid(@PathVariable("id") String id, @RequestBody Cliente tutorial) {
		  Optional<Cliente> tutorialData = tutorialRepository.findById(id);

		  if (tutorialData.isPresent()) {
		    Cliente _tutorial = tutorialData.get();
		    _tutorial.setCedula(tutorial.getCedula());
		    _tutorial.setDireccion_cliente(tutorial.getDireccion_cliente());
		    _tutorial.setEmail_cliente(tutorial.getEmail_cliente());
		    _tutorial.setNombre_cliente(tutorial.getNombre_cliente());
		    _tutorial.setTelefono_cliente(tutorial.getTelefono_cliente());
		    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	  

	  
	  @DeleteMapping("/ClientesEliminarID/{id}") 
	  public ResponseEntity<HttpStatus> BorrarPorId(String id) {
		  try {
			    tutorialRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @DeleteMapping("/ClientesEliminarCedula/{cedula}")
	  public ResponseEntity<HttpStatus> BorrarPorcedula(String cedula) {
		  try {
			  List<Cliente> clientes = new ArrayList<Cliente>();
			    tutorialRepository.findBycedulaContaining(cedula).forEach(clientes::add);

			    if (clientes.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			    tutorialRepository.deleteAll(clientes);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @PutMapping("/ActualizarClientes/{cedula}")
	  public ResponseEntity<Cliente> ActualizarClientecedula(@PathVariable("cedula") String cedula, @RequestBody Cliente tutorial){
		  Optional<Cliente> tutorialData = tutorialRepository.findById(cedula);
		  if (tutorialData.isPresent()) {
		    Cliente _tutorial = tutorialData.get();
		    _tutorial.setDireccion_cliente(tutorial.getDireccion_cliente());
		    _tutorial.setEmail_cliente(tutorial.getEmail_cliente());
		    _tutorial.setNombre_cliente(tutorial.getNombre_cliente());
		    _tutorial.setTelefono_cliente(tutorial.getTelefono_cliente());
		    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/Clientes")
	  public ResponseEntity<HttpStatus> BorrarTodo() {
		  try {
			    tutorialRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

}
