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

import edu.uni.miuniversidad.domain.Asignatura;
import edu.uni.miuniversidad.services.AsignaturaServiceImpl;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturasController {

	private AsignaturaServiceImpl asignaturaServiceImpl;

	public AsignaturasController(AsignaturaServiceImpl asignaturaServiceImpl) {
		super();
		this.asignaturaServiceImpl = asignaturaServiceImpl;
	}

	@PostMapping
	public Asignatura create(@RequestBody Asignatura asignatura) {
		return asignaturaServiceImpl.create(asignatura);
	}

	@GetMapping
	public List<Asignatura> findAll() {
		return asignaturaServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Asignatura findById(@PathVariable Integer id) {
		return asignaturaServiceImpl.findById(id);
	}
	
	@PutMapping("/{id}")
	public Asignatura update(@PathVariable Integer id, @RequestBody Asignatura asignaturaDTO) {
		return asignaturaServiceImpl.update(id, asignaturaDTO);
	}
	
	@DeleteMapping("/{id}")
	public Asignatura delete(@PathVariable Integer id) {
		return asignaturaServiceImpl.delete(id);
	}
}
