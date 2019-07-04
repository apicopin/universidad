package edu.uni.miuniversidad.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.domain.Profesor;
import edu.uni.miuniversidad.repositories.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	private ProfesorRepository profesorRepository;

	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	@Override
	public Profesor create(Profesor profesor) {
		profesorRepository.findById(profesor.getDni()).ifPresent(t -> {throw new RuntimeException("Profesor " + t.getDni() + " ya existe");}); 
		
		return profesorRepository.save(profesor);
	}
	
	@Override
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}
	
	@Override
	public Profesor findById(String dni) {
		return profesorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
	}
	
	@Override
	public Profesor update(String dni, Profesor profesor) {
		Profesor profesorUpdate = findById(dni);
	
		profesorUpdate.setNombre(profesor.getNombre());
		profesorUpdate.setApellidos(profesor.getApellidos());

		return profesorRepository.save(profesorUpdate);
	}
	
	@Override
	public Profesor delete(String dni) {
		Profesor profesor = findById(dni);
		profesorRepository.delete(profesor);
		
		return profesor;
	}
}
