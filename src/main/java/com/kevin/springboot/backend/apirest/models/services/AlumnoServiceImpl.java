package com.kevin.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.springboot.backend.apirest.models.dao.IAlumnoDao;
import com.kevin.springboot.backend.apirest.models.entity.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.deleteById(id);
	}

	@Override
	public Alumno findAlumnoByCarnet(String carnet) {
		// TODO Auto-generated method stub
		return alumnoDao.findAlumnoByCarnet(carnet);
	}
	
	

}
