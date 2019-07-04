package edu.uni.miuniversidad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESORES")
public class Profesor extends AbstractPersona {

	@OneToOne(mappedBy = "profesor")
    private Asignatura asignatura;
	
}
