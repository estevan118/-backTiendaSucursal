package co.edu.lagenerica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.lagenerica.model.Consolidado;
import co.edu.lagenerica.repository.ConsolidadoRepository;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/consolidado")
public class ConsolidadoController {
	
	@Autowired
	 ConsolidadoRepository consolidadoRepository;
	
	
	@GetMapping("/Consolidado")
	public ResponseEntity<List<Consolidado>> MostrarPorCiudad(@RequestParam(required = false) String ciudad) {
		  try {
			    List<Consolidado> consolidado = new ArrayList<Consolidado>();

			    if (ciudad == null)
			    	consolidadoRepository.findAll().forEach(consolidado::add);
			    else
			    	consolidadoRepository.findByciudadContaining(ciudad).forEach(consolidado::add);

			    if (consolidado.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(consolidado, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
}
	
	

}
