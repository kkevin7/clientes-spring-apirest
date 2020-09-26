package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import com.kevin.springboot.backend.apirest.models.entity.Profesor;

public interface IProfesorService {
	
	public List<Profesor> findAll();
	
	public Profesor findById(Long id);
	
	public Profesor save(Profesor cliente);
	
	public void delete (Long id);

}
