package edu.uni.miuniversidad.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.uni.miuniversidad.domain.ResultadoExamen;

public interface ResultadoExamenRepository extends JpaRepository<ResultadoExamen, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "LOAD DATA LOCAL INFILE ?1 INTO TABLE RESULTADOS_EXAMEN FIELDS TERMINATED BY ';' (ID, NOTA, ALUMNO_DNI, EXAMEN_ID)", nativeQuery = true)
	public void load(String datos);

}
