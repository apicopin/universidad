package edu.uni.miuniversidad.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.domain.Alumno;
import edu.uni.miuniversidad.repositories.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	private AlumnoRepository alumnoRepository;

	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		super();
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	public Alumno create(Alumno alumno) {
		alumnoRepository.findById(alumno.getDni()).ifPresent(t -> {throw new RuntimeException("Alumno " + t.getDni() + " ya existe");}); 
		
		return alumnoRepository.save(alumno);
	}
	
	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}
	
	@Override
	public Alumno findById(String dni) {
		return alumnoRepository.findById(dni).orElseThrow(() -> new RuntimeException("Alumno " + dni + " no encontrado"));
	}
	
	@Override
	public Alumno update(String dni, Alumno alumno) {
		Alumno alumnoUpdate = findById(dni);
	
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellidos(alumno.getApellidos());

		return alumnoRepository.save(alumnoUpdate);
	}
	
	@Override
	public Alumno delete(String dni) {
		Alumno alumno = findById(dni);
		alumnoRepository.delete(alumno);
		
		return alumno;
	}
	
}
