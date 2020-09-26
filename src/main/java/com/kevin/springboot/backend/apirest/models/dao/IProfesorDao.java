package com.kevin.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.kevin.springboot.backend.apirest.models.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long>{

}
