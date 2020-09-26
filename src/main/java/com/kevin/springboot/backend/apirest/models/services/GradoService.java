package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.springboot.backend.apirest.models.dao.IGradoDao;
import com.kevin.springboot.backend.apirest.models.entity.Grado;

@Service
public class GradoService implements IGradoService {
	
	@Autowired
	private IGradoDao gradoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Grado> findAll() {
		// TODO Auto-generated method stub
		return (List<Grado>) gradoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findById(Long id) {
		// TODO Auto-generated method stub
		return gradoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Grado save(Grado grado) {
		// TODO Auto-generated method stub
		return gradoDao.save(grado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		gradoDao.deleteById(id);
	}

}
