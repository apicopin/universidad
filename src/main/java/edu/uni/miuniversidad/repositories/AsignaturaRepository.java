package edu.uni.miuniversidad.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.uni.miuniversidad.domain.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE ASIGNATURAS FIELDS TERMINATED BY ';' lines terminated by '\\r\\n' (ID, NOMBRE, PROFESOR_DNI)", nativeQuery = true)
	public void load(String datos);

	@Query(value = "SELECT ID, NOMBRE, PROFESOR_DNI FROM ASIGNATURAS WHERE NOMBRE = ?1", nativeQuery = true)
	public Asignatura findByNombre(String nombre);
	
}
