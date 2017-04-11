package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import model.Estudiante;
import model.Asignacion;
import model.Asignaciones;
import sun.rmi.runtime.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

/* Para el ejemplo se usara el siguiente recurso
*  https://www.googleapis.com/books/v1/volumes/?q=isbn:9706434526&fields=totalItems,items(id,volumeInfo(title,publishedDate))
* */

public class RequestService {
	private Client client;
	private static final String NOTITAS = "http://notitas.herokuapp.com";
	private static final String RESOURCE_STUDENTS = "student";
	private static final String RESOURCE_ASSIGNMENTS = "student/assignments";
	private static final Logger logger = Logger.getLogger(RequestService.class);

	public RequestService() {
		this.client = Client.create();
	}

	//Token de prueba hardcodeado: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho
	public Estudiante getStudentByToken(String token) {
		WebResource recurso = this.client.resource(NOTITAS).path(RESOURCE_STUDENTS);
		WebResource.Builder recursoConHeader = recurso
				.header("Authorization", "Bearer " + token)
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = recursoConHeader.get(ClientResponse.class);

		String respuesta = response.getEntity(String.class);
		Estudiante estudiante = null;
		Gson gson = new Gson();

		if (response.getStatus() != 200) {
			System.out.print(recursoConHeader.toString());
			throw new RuntimeException("Error HTTP: " + response.getStatus());
		}

		if (respuesta.contains("code")) {
			System.out.println(respuesta);
			estudiante = gson.fromJson(respuesta, Estudiante.class);
		} else {
			logger.error("No se obtuvo un resultado de tipo Estudiante.");
		}

		return estudiante;
	}

	public Asignaciones getAssignmentsForStudent(String token) {
		Gson gson = new Gson();
		WebResource recurso = this.client.resource(NOTITAS).path(RESOURCE_ASSIGNMENTS);
		WebResource.Builder recursoConHeader = recurso
				.header("Authorization", "Bearer " + token)
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = recursoConHeader.get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			System.out.print("Authorization : Bearer " + token);
			throw new RuntimeException("Error HTTP: " + response.getStatus());
		}
		
		String respuesta = response.getEntity(String.class);
		Asignaciones asignaciones = null; 

		if (respuesta.contains("assignments")) {
			System.out.println(respuesta);
			asignaciones = gson.fromJson(respuesta, Asignaciones.class);
		} else {
			logger.error("No se obtuvo un resultado de tipo Asignaciones.");
		}
		
		return asignaciones;
	}
	
	public boolean createStudent(Estudiante estudiante, String token) {
		Gson gson = new Gson();
		WebResource recurso = this.client.resource(NOTITAS).path(RESOURCE_STUDENTS);
		WebResource.Builder recursoConHeader = recurso
				.header("Authorization", "Bearer " + token)
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		String estudianteJson = gson.toJson(estudiante);
		ClientResponse response = recursoConHeader.put(ClientResponse.class, estudianteJson);
		
		if (response.getStatus() != 201) {
			System.out.print(recursoConHeader.toString());
			System.out.print(estudianteJson.toString());
			throw new RuntimeException("Error HTTP PUT: " + response.getStatus());
		}
		
		return true;
		
	}

}