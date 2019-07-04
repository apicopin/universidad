package edu.uni.miuniversidad.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.uni.miuniversidad.domain.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE EXAMENES FIELDS TERMINATED BY ';' (ID, FECHA, ASIGNATURA_ID)", nativeQuery = true)
	public void load(String datos);

}
