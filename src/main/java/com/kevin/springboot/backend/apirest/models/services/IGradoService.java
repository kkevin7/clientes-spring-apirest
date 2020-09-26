package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import com.kevin.springboot.backend.apirest.models.entity.Grado;

public interface IGradoService {

	public List<Grado> findAll();
	
	public Grado findById(Long id);
	
	public Grado save(Grado cliente);
	
	public void delete (Long id);
}
