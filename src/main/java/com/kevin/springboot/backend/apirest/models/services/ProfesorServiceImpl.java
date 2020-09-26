package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.springboot.backend.apirest.models.dao.IProfesorDao;
import com.kevin.springboot.backend.apirest.models.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private IProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		// TODO Auto-generated method stub
		return profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return profesorDao.save(profesor);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		profesorDao.deleteById(id);
	}
	
}
