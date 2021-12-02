package com.equipox.misiontic2022.tiendasgenericas.tiendastrom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.model.Reportes;
import com.equipox.misiontic2022.tiendasgenericas.tiendastrom.repository.ReportesRepository;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reporte")
public class ReportesController {
	
	@Autowired
	 ReportesRepository reportesRepository;
	
	@GetMapping("/reportes")
	public ResponseEntity<List<Reportes>> MostrarPorCedula(@RequestParam(required = false) String cedula) {
		  try {
			    List<Reportes> ventas = new ArrayList<Reportes>();

			    if (cedula == null)
			    	reportesRepository.findAll().forEach(ventas::add);
			    else
			    	reportesRepository.findBycedulaContaining(cedula).forEach(ventas::add);

			    if (ventas.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(ventas, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
}
	@PostMapping("/Clientes")
	  public ResponseEntity<Reportes> CrearCliente(@RequestBody Reportes lista) {
		  try {
			    Reportes reporterepositorio= reportesRepository.save(new Reportes(lista.getCedula(),lista.getCodigo_venta(),lista.getDetalleventa(),lista.getTotalventa(),lista.getValorventa(),lista.getIvaventa()));
			    return new ResponseEntity<>(reporterepositorio , HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	
}
