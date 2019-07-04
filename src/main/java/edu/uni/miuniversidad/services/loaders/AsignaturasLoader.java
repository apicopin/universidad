package edu.uni.miuniversidad.services.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.repositories.AsignaturaRepository;
import edu.uni.miuniversidad.repositories.ProfesorRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsignaturasLoader {

	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Value("${universidad.carga.asignaturas}")
	private String ficheroAsignaturas;
	
	public AsignaturasLoader(AsignaturaRepository asignaturaRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
	}
	
	public void cargaInicial() {

		if (asignaturaRepository.count() > 0) {
			log.info("Ya existen asignaturas en la tabla.");
			return;
		}

		if (profesorRepository.count() == 0) {
			log.info("No hay profesores en tabla para asignarles las asignaturas.");
			return;
		}

		asignaturaRepository.load(ficheroAsignaturas);
		log.info("Tabla 'ASIGNATURA' cargada correctamente!");

		return;
	}
	
}
