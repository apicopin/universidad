package edu.uni.miuniversidad.services;

import java.util.List;

import edu.uni.miuniversidad.domain.Asignatura;

public interface AsignaturaService {

	Asignatura create(Asignatura asignatura);

	List<Asignatura> findAll();

	Asignatura findById(Integer id);

	Asignatura update(Integer id, Asignatura asignatura);

	Asignatura delete(Integer id);
	
}
