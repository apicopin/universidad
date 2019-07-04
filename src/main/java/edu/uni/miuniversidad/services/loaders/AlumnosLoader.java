package edu.uni.miuniversidad.services.loaders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.repositories.AlumnoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Profile("!test")
public class AlumnosLoader {
	
	private AlumnoRepository alumnoRepository;

	@Value("${universidad.carga.alumnos}")
	private String ficheroAlumnos;
	
	public AlumnosLoader(AlumnoRepository alumnoRepository) {
		super();
		this.alumnoRepository = alumnoRepository;
	}
	
	public void cargaInicial() {

		if (alumnoRepository.count() > 0) {
			log.info("Ya existen alumnos en la tabla.");
			return;
		}

		alumnoRepository.load(ficheroAlumnos);
		log.info("Tabla 'ALUMNO' cargada correctamente!");
		
		alumnoRepository.loadAsignaturasAlumnos(ficheroAlumnos);
		log.info("Alumnos cargados en las Asignaturas correctamente!");
		
		return;
	}

}
