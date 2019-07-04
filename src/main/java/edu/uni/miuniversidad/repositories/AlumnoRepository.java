package edu.uni.miuniversidad.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.uni.miuniversidad.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE ALUMNOS FIELDS TERMINATED BY ';' (DNI, NOMBRE, APELLIDOS)", nativeQuery = true)
	public void load(String datos);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE ASIGNATURAS_ALUMNOS FIELDS TERMINATED BY ';' (ALUMNOS_DNI, @dummy, @dummy, ASIGNATURA_ID)", nativeQuery = true)
	public void loadAsignaturasAlumnos(String datos);

}
