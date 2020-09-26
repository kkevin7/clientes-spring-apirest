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

import com.kevin.springboot.backend.apirest.models.entity.Profesor;
import com.kevin.springboot.backend.apirest.models.services.IProfesorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@GetMapping("/profesores")
	public List<Profesor> index(){
		return profesorService.findAll();
	}
	
	@GetMapping("/profesores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Profesor profesor = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			profesor = profesorService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(profesor == null) {
			response.put("mensaje", "El profesor ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
	}
	
	@PostMapping("/profesores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Profesor profesor) {
		
		Profesor profesorNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			profesorNew = profesorService.save(profesor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El profesor ha sido creado con éxito");
		response.put("profesor", profesorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/profesores/{id}")
	public ResponseEntity<?> update(@RequestBody Profesor profesor, @PathVariable Long id) {
		
		Profesor profesorActual = profesorService.findById(id);
		Profesor profesorUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(profesor == null) {
			response.put("mensaje", "Error, no se puede editar, el profesor ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			profesorActual.setNombre(profesor.getNombre());
			profesorActual.setApellidos(profesor.getApellidos());
			profesorActual.setGrado(profesor.getGrado());
			profesorActual.setEdad(profesor.getEdad());
			profesorActual.setSexo(profesor.getSexo());
			profesorActual.setTitulo(profesor.getTitulo());

			profesorUpdated = profesorService.save(profesorActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El profesor ha sido actualizado con éxito");
		response.put("profesor", profesorUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/profesores/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			profesorService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El profesor ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
