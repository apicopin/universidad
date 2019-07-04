package edu.uni.miuniversidad.services;

import java.util.List;

import edu.uni.miuniversidad.domain.Profesor;

public interface ProfesorService {

	Profesor create(Profesor profesor);

	List<Profesor> findAll();

	Profesor findById(String dni);

	Profesor update(String dni, Profesor profesor);

	Profesor delete(String dni);
	
}
