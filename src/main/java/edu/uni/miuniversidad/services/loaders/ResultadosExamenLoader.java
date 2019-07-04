package edu.uni.miuniversidad.services.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.repositories.AlumnoRepository;
import edu.uni.miuniversidad.repositories.ExamenRepository;
import edu.uni.miuniversidad.repositories.ResultadoExamenRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResultadosExamenLoader {

	private ResultadoExamenRepository resultadoExamenRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private ExamenRepository examenRepository;
	
	@Value("${universidad.carga.resultadosexamen}")
	private String ficheroResultadosExamen;
	
	public ResultadosExamenLoader(ResultadoExamenRepository resultadoExamenRepository) {
		super();
		this.resultadoExamenRepository = resultadoExamenRepository;
	}
	
	public void cargaInicial() {

		if (resultadoExamenRepository.count() > 0) {
			log.info("Ya existen resultados de exámenes en la tabla.");
			return;
		}

		if (alumnoRepository.count() == 0) {
			log.info("No hay alumnos en tabla para asignarles notas.");
			return;
		}

		if (examenRepository.count() == 0) {
			log.info("No hay examenes en tabla para asignarles notas.");
			return;
		}

		resultadoExamenRepository.load(ficheroResultadosExamen);
		log.info("Tabla 'RESULTADO_EXAMEN' cargada correctamente!");

		return;
	}
}
