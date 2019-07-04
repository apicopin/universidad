package edu.uni.miuniversidad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.uni.miuniversidad.services.loaders.ServiceLoader;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class UniversidadApplication implements CommandLineRunner {

	private ServiceLoader serviceLoader;

	public UniversidadApplication(ServiceLoader serviceLoader) {
		super();
		this.serviceLoader = serviceLoader;
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Universidad en marcha!!");
		serviceLoader.load();
	}

}
