package edu.uni.miuniversidad.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.domain.Asignatura;
import edu.uni.miuniversidad.repositories.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

	private AsignaturaRepository asignaturaRepository;

	public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
	}

	@Override
	public Asignatura create(Asignatura asignatura) {
		Asignatura asig = asignaturaRepository.findByNombre(asignatura.getNombre());
		if (asig != null) {
			asignaturaRepository.findById(asig.getId()).ifPresent(t -> {throw new RuntimeException("Asignatura " + asig.getNombre() + " ya existe");});	
		}

		return asignaturaRepository.save(asignatura);
	}
	
	@Override
	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}
	
	@Override
	public Asignatura findById(Integer id) {
		return asignaturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
	}
	
	@Override
	public Asignatura update(Integer id, Asignatura asignatura) {
		Asignatura asignaturaUpdate = findById(id);
	
		asignaturaUpdate.setNombre(asignatura.getNombre());
		asignaturaUpdate.setProfesor(asignatura.getProfesor());
		asignaturaUpdate.setAlumnos(asignatura.getAlumnos());

		return asignaturaRepository.save(asignaturaUpdate);
	}
	
	@Override
	public Asignatura delete(Integer id) {
		Asignatura asignatura = findById(id);
		asignaturaRepository.delete(asignatura);
		
		return asignatura;
	}
}
