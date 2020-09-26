package com.kevin.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kevin.springboot.backend.apirest.models.entity.Alumno;

public interface IAlumnoDao  extends CrudRepository<Alumno, Long> {

	@Query("SELECT u FROM Alumno u WHERE u.carnet = ?1")
	Alumno findAlumnoByCarnet(String carnet);
}
