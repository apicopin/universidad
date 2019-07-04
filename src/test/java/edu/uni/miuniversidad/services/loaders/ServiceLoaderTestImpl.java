package edu.uni.miuniversidad.services.loaders;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import edu.uni.miuniversidad.services.loaders.ServiceLoader;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Profile("test")
public class ServiceLoaderTestImpl implements ServiceLoader {
	
	public void load() {
		log.warn("En pruebas...");
	}

}
