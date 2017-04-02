package Test;

import com.sun.jersey.api.client.ClientResponse;

import model.Asignacion;
import model.Asignaciones;
import model.Estudiante;
import services.RequestService;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

public class RequestServiceTest {

	RequestService requester;

	@Before
	public void setUp() throws Exception {
		this.requester = new RequestService();
		BasicConfigurator.configure();
	}

	@Test
	public void obtenerEstudiante() throws Exception {
		// Se solicitan los datos de un estudiante.
		Estudiante estudiante = this.requester.getStudentByToken(
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		System.out.println(estudiante.getLegajo());
		System.out.println(estudiante.getApellido());
		System.out.println(estudiante.getUsuarioGithub());
		assertTrue(estudiante != null);
	}

	@Test
	public void obtenerAsignaciones() throws Exception {
		// Se solicitan asignaciones
		Asignaciones asignaciones = new Asignaciones();
		asignaciones = this.requester.getAssignmentsForStudent(
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		assertTrue(asignaciones.getAsignaciones().size() != 0);
	}

	@Test
	public void cargarEstudiante() throws Exception {
		// Se cargan los datos de un estudiante.
		boolean resultado = false;
		Estudiante estudiante = new Estudiante();
		estudiante.setLegajo(666);
		estudiante.setNombre("Susana");
		estudiante.setApellido("Peralta");
		estudiante.setUsuarioGithub("La_Susy_Piola");
		resultado = this.requester.createStudent(estudiante,
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		assertTrue(resultado);
	}

}
