package edu.uni.miuniversidad.services.loaders;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test")
public class ServiceLoaderImpl implements ServiceLoader {
	
	private ProfesoresLoader profesoresLoader;
	private AsignaturasLoader asignaturasLoader;
	private AlumnosLoader alumnosLoader;
	private ExamenesLoader examenesLoader;
	private ResultadosExamenLoader resultadosExamenLoader;
	
	public ServiceLoaderImpl(ProfesoresLoader profesoresLoader,
			             AsignaturasLoader asignaturasLoader,
			             AlumnosLoader alumnosLoader,
			             ExamenesLoader examenesLoader,
			             ResultadosExamenLoader resultadosExamenLoader) {
		super();
		this.profesoresLoader = profesoresLoader;
		this.asignaturasLoader = asignaturasLoader;
		this.alumnosLoader = alumnosLoader;
		this.examenesLoader = examenesLoader;
		this.resultadosExamenLoader = resultadosExamenLoader;
	}
	
	@Override
	public void load() {
		profesoresLoader.cargaInicial();
		asignaturasLoader.cargaInicial();
		alumnosLoader.cargaInicial();
		examenesLoader.cargaInicial();
		resultadosExamenLoader.cargaInicial();
	}

}
