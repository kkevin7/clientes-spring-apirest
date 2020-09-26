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

import com.kevin.springboot.backend.apirest.models.entity.Alumno;
import com.kevin.springboot.backend.apirest.models.services.IAlumnoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AlumnoRestController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/alumnos")
	public List<Alumno> index(){
		return alumnoService.findAll();
	}
	
	@GetMapping("/alumnos/carnet/{carnet}")
	public Alumno findByCarnet(@PathVariable String carnet){
		return alumnoService.findAlumnoByCarnet(carnet);
	}
	
	@GetMapping("/alumnos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Alumno alumno = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			alumno = alumnoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(alumno == null) {
			response.put("mensaje", "El alumno ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}
	
	@PostMapping("/alumnos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Alumno alumno) {
		
		Alumno alumnoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			alumnoNew = alumnoService.save(alumno);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El alumno ha sido creado con éxito");
		response.put("alumno", alumnoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/alumnos/{id}")
	public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable Long id) {
		
		Alumno alumnoActual = alumnoService.findById(id);
		Alumno alumnoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(alumno == null) {
			response.put("mensaje", "Error, no se puede editar, el alumno ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			alumnoActual.setNombre(alumno.getNombre());
			alumnoActual.setApellidos(alumno.getApellidos());
			alumnoActual.setCarnet(alumno.getCarnet());
			alumnoActual.setGrado(alumno.getGrado());
			alumnoActual.setNombrePadre(alumno.getNombrePadre());
			alumnoActual.setNombreMadre(alumno.getNombreMadre());
			alumnoActual.setEdad(alumno.getEdad());
			alumnoActual.setNotaFinal(alumno.getNotaFinal());

			alumnoUpdated = alumnoService.save(alumnoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El alumno ha sido actualizado con éxito");
		response.put("alumno", alumnoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/alumnos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			alumnoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El alumno ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
