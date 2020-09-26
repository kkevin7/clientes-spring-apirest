package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.kevin.springboot.backend.apirest.models.entity.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	
	public Alumno findById(Long id);
	
	public Alumno save(Alumno cliente);
	
	public void delete (Long id);
	
	public Alumno findAlumnoByCarnet(String carnet);

}
