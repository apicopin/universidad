package edu.uni.miuniversidad.services.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.repositories.AsignaturaRepository;
import edu.uni.miuniversidad.repositories.ExamenRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExamenesLoader {

	private ExamenRepository examenRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Value("${universidad.carga.examenes}")
	private String ficheroExamenes;
	
	public ExamenesLoader(ExamenRepository examenRepository) {
		super();
		this.examenRepository = examenRepository;
	}
	
	public void cargaInicial() {

		if (examenRepository.count() > 0) {
			log.info("Ya existen examenes en la tabla.");
			return;
		}

		if (asignaturaRepository.count() == 0) {
			log.info("No hay asignaturas en tabla para asignarles los examenes.");
			return;
		}

		examenRepository.load(ficheroExamenes);
		log.info("Tabla 'EXAMEN' cargada correctamente!");

		return;
	}
}
