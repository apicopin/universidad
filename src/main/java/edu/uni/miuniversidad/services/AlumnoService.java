package edu.uni.miuniversidad.services;

import java.util.List;

import edu.uni.miuniversidad.domain.Alumno;

public interface AlumnoService {

	Alumno create(Alumno alumno);

	List<Alumno> findAll();

	Alumno findById(String dni);

	Alumno update(String dni, Alumno alumno);

	Alumno delete(String dni);

}