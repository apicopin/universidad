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

import edu.uni.miuniversidad.domain.Profesor;
import edu.uni.miuniversidad.services.ProfesorServiceImpl;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {

	private ProfesorServiceImpl profesorServiceImpl;

	public ProfesoresController(ProfesorServiceImpl profesorServiceImpl) {
		super();
		this.profesorServiceImpl = profesorServiceImpl;
	}

	@PostMapping
	public Profesor create(@RequestBody Profesor profesor) {
		return profesorServiceImpl.create(profesor);
	}

	@GetMapping
	public List<Profesor> findAll() {
		return profesorServiceImpl.findAll();
	}
	
	@GetMapping("/{dni}")
	public Profesor findById(@PathVariable String dni) {
		return profesorServiceImpl.findById(dni);
	}
	
	@PutMapping("/{dni}")
	public Profesor update(@PathVariable String dni, @RequestBody Profesor profesorDTO) {
		return profesorServiceImpl.update(dni, profesorDTO);
	}
	
	@DeleteMapping("/{dni}")
	public Profesor delete(@PathVariable String dni) {
		return profesorServiceImpl.delete(dni);
	}
}
