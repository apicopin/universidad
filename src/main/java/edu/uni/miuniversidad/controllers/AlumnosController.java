package edu.uni.miuniversidad.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uni.miuniversidad.domain.Alumno;
import edu.uni.miuniversidad.services.AlumnoServiceImpl;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

	private AlumnoServiceImpl alumnoServiceImpl;

	public AlumnosController(AlumnoServiceImpl alumnoServiceImpl) {
		super();
		this.alumnoServiceImpl = alumnoServiceImpl;
	}

	@PostMapping
	public Alumno create(@RequestBody Alumno alumno) {
		return alumnoServiceImpl.create(alumno);
	}

	@GetMapping
	public List<Alumno> findAll() {
		return alumnoServiceImpl.findAll();
	}
	
	@GetMapping("/{dni}")
	public Alumno findById(@PathVariable String dni) {
		return alumnoServiceImpl.findById(dni);
	}
	
	@PutMapping("/{dni}")
	public Alumno update(@PathVariable String dni, @RequestBody Alumno alumnoDTO) {
		return alumnoServiceImpl.update(dni, alumnoDTO);
	}
	
	@DeleteMapping("/{dni}")
	public Alumno delete(@PathVariable String dni) {
		return alumnoServiceImpl.delete(dni);
	}

}
