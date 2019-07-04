package edu.uni.miuniversidad.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ASIGNATURAS")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@OneToOne
	@JoinColumn(name="PROFESOR_DNI", nullable = true)
	private Profesor profesor;

	@OneToMany
	private List<Alumno> alumnos;

}
