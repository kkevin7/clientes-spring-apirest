package com.kevin.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.springboot.backend.apirest.models.entity.Grado;
import com.kevin.springboot.backend.apirest.models.services.IGradoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class GradoRestController {
	
	@Autowired
	private IGradoService gradoService;
	
	@GetMapping("/grados")
	public List<Grado> index(){
		return gradoService.findAll();
	}
	
	@GetMapping("/grados/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Grado grado = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			grado = gradoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(grado == null) {
			response.put("mensaje", "El grado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Grado>(grado, HttpStatus.OK);
	}
	
	@PostMapping("/grados")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Grado grado) {
		
		Grado gradoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			gradoNew = gradoService.save(grado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grado ha sido creado con éxito");
		response.put("grado", gradoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/grados/{id}")
	public ResponseEntity<?> update(@RequestBody Grado grado, @PathVariable Long id) {
		
		Grado gradoActual = gradoService.findById(id);
		Grado gradoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(grado == null) {
			response.put("mensaje", "Error, no se puede editar, el grado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			gradoActual.setNombre(grado.getNombre());

			gradoUpdated = gradoService.save(gradoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El grado ha sido actualizado con éxito");
		response.put("grado", gradoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/grados/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			gradoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grado ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
