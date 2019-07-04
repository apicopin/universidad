package edu.uni.miuniversidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uni.miuniversidad.controllers.AlumnosController;
import edu.uni.miuniversidad.domain.Alumno;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UniversidadApplication.class)
public class UniversidadApplicationTests {

	@Autowired
	private AlumnosController controller;
	
	@Before
	public void setUp() {
		Alumno alumno = new Alumno();
		alumno.setDni("999888777B");
		alumno.setNombre("prueba2");
		alumno.setApellidos("apellidos2");
		controller.create(alumno);
	}
	
	@After
	public void tearDown() {
		controller.delete("999888777B");
	}

	@Test
	public void testCrearAlumno() {
		// Arrange
		Alumno alumno = new Alumno();
		alumno.setDni("111222333A");
		alumno.setNombre("prueba1");
		alumno.setApellidos("apellidos1");
		
		// Act
		Alumno resultado = controller.create(alumno);
		
		// Assert
		assertNotNull("Null no esperado", resultado);
		assertEquals("DNI diferente", alumno.getDni(), resultado.getDni());
	}
	
	@Test
	public void testBuscarAlumno() {
		// Arrange
		String dni = "999888777B";
		
		// Act
		Alumno resultado = controller.findById(dni);

		// Assert
		assertNotNull("Null no esperado", resultado);
		assertEquals("DNI diferente", dni, resultado.getDni());
	}

}
