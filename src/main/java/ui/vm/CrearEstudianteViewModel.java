package ui.vm;

import model.Asignacion;
import model.Estudiante;
import services.RequestService;

import org.uqbar.commons.utils.Observable;
import org.apache.log4j.BasicConfigurator;
import java.util.List;


@Observable
public class CrearEstudianteViewModel{
	private String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	private RequestService requester;
	private String estudianteApellido, estudianteNombre, estudianteUsuario;
	private Integer estudianteLegajo;
	
	public void setUp(){
		this.requester = new RequestService();
		BasicConfigurator.configure();
	}
	
	Estudiante estudiante = new Estudiante();
	
	public void guardarEstudiante() {
		this.setUp();

		estudiante.setLegajo(estudianteLegajo);
		estudiante.setApellido(estudianteApellido);
		estudiante.setNombre(estudianteNombre);
		estudiante.setUsuarioGithub(estudianteUsuario);
		
		this.requester.createStudent(estudiante,token);
	}
	
	//Getters	
	public int getEstudianteLegajo(){
		return this.estudianteLegajo;
	}
	public String getEstudianteApellido(){
		return this.estudianteApellido;
	}
	public String getEstudianteNombre(){
		return this.estudianteNombre;
	}
	public String getEstudianteUsuario(){
		return this.estudianteUsuario;
	}
	
	public void setLegajo(Integer estudianteLegajo){
		estudiante.setLegajo(estudianteLegajo);
	}
	
	public void setNombre(String estudianteNombre){
		estudiante.setNombre(estudianteNombre);
	}
	public void setApellido(String estudianteApellido){
		estudiante.setApellido(estudianteApellido);
	}
	public void setUsuarioGithub(String estudianteUsuario){
		estudiante.setUsuarioGithub(estudianteUsuario);
	}

/*	public void crearEstudiante(){
		this.requester.createStudent(estudiante,token);
	}*/
	
}