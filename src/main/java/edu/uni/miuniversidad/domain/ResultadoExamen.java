package edu.uni.miuniversidad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "RESULTADOS_EXAMEN", uniqueConstraints={@UniqueConstraint(columnNames={"ALUMNO_DNI", "EXAMEN_ID"})})
@Data
public class ResultadoExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="ALUMNO_DNI", nullable = false)
	private Alumno alumno;
	
	@OneToOne
	@JoinColumn(name="EXAMEN_ID", nullable = false)
	private Examen examen;
	
	@Column(name="NOTA")
	Double nota;
	
}
