package com.kevin.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.kevin.springboot.backend.apirest.models.entity.Grado;

public interface IGradoDao extends CrudRepository<Grado, Long>{

}
