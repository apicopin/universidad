package edu.uni.miuniversidad.services.loaders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.repositories.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfesoresLoader {

	private ProfesorRepository profesorRepository;

	@Value("${universidad.carga.profesores}")
	private String ficheroProfesores;
	
	public ProfesoresLoader(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	public void cargaInicial() {
		
		if (profesorRepository.count() > 0) {
			log.info("Ya existen profesores en la tabla.");
			return;
		}
		
		profesorRepository.load(ficheroProfesores);
		log.info("Tabla 'PROFESOR' cargada correctamente!");

		return;
	}
	
}
