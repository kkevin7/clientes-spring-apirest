package com.kevin.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.springboot.backend.apirest.models.entity.Empleado;
import com.kevin.springboot.backend.apirest.models.services.IEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> index(){
		return empleadoService.findAll();
	}
	
//	@GetMapping("/empleados/{id}")
//	public ResponseEntity<?> show(@PathVariable Long id){
//		
//		Empleado empleado = null;
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			empleado = empleadoService.findById(id);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		if(empleado == null) {
//			response.put("mensaje", "El empleado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
//	}
//	
//	@PostMapping("/empleados")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<?> create(@RequestBody Empleado empleado) {
//		
//		Empleado empleadoNew = null;
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			empleadoNew = empleadoService.save(empleado);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "El empleado ha sido creado con éxito");
//		response.put("empleado", empleadoNew);
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//
//	@PutMapping("/empleados/{id}")
//	public ResponseEntity<?> update(@RequestBody Empleado empleado, @PathVariable Long id) {
//		
//		Empleado empleadoActual = empleadoService.findById(id);
//		Empleado empleadoUpdated = null;
//		Map<String, Object> response = new HashMap<>();
//		
//		if(empleado == null) {
//			response.put("mensaje", "Error, no se puede editar, el empleado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		try {
//			empleadoActual.setNombre(empleado.getNombre());
//			empleadoActual.setApellido(empleado.getApellido());
//			empleadoActual.setEmpresa(empleado.getEmpresa());
//			empleadoActual.setCreateAt(empleado.getCreateAt());
//
//			empleadoUpdated = empleadoService.save(empleadoActual);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		response.put("mensaje", "El empleado ha sido actualizado con éxito");
//		response.put("empleado", empleadoUpdated);
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/empleados/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			empleadoService.delete(id);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar la consulta en la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "El empleado ha sido eliminado con éxito");
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//	}

	
}
