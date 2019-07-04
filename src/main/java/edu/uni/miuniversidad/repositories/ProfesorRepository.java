package edu.uni.miuniversidad.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.uni.miuniversidad.domain.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE PROFESORES FIELDS TERMINATED BY ';' (DNI, NOMBRE, APELLIDOS)", nativeQuery = true)
	public void load(String datos);
	
}
