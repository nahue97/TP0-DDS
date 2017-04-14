package ui;

import model.Asignacion;
import model.Estudiante;
import services.RequestService;

import org.uqbar.commons.utils.Observable;
import org.apache.log4j.BasicConfigurator;
import java.util.List;


@Observable
public class NotasViewModel{
	private String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	private RequestService requester;
	private String estudianteApellido, estudianteNombre, estudianteUsuario;
	private Integer estudianteLegajo;
	private List <Asignacion> listaDeAsignaturas;
	
	public void setUp(){
		this.requester = new RequestService();
		BasicConfigurator.configure();
	}
	
	public void obtenerEstudiante() {
		this.setUp();
		
		Estudiante estudiante = this.requester.getStudentByToken(token);
		
		estudianteLegajo = estudiante.getLegajo();
		estudianteApellido = estudiante.getApellido();
		estudianteNombre = estudiante.getNombre();
		estudianteUsuario = estudiante.getUsuarioGithub();
		listaDeAsignaturas = this.requester.getAssignmentsForStudent(token).getAsignaciones();
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
	public String getToken(){
		return this.token;
	}
	public List<Asignacion> getListaDeAsignaturas(){
		return this.listaDeAsignaturas;
	}
	//Setters
	public void setListaDeAsignaturas(List <Asignacion> listaDeAsignaturas){
		this.listaDeAsignaturas = listaDeAsignaturas;
	}
	
	public void setToken(String unToken){
		this.token = unToken;
	}
	
}
	/* Toda la parte de modificar el usuario, desear�a saber c�mo hacerlo en una ventana nueva
	//Crear Estudiante
	
	Estudiante estudiante = new Estudiante();
	
	public void setLegajo(int estudianteLegajo){
		estudiante.setLegajo(666);
	}
	
	public void setNombre(){
		estudiante.setNombre("Susana");
	}
	public void setApellido(){
		estudiante.setApellido("Peralta");
	}
	public void setUsuarioGithub(){
		estudiante.setUsuarioGithub("La_Susy_Piola");
	}
	public void crearEstudiante(){
		this.requester.createStudent(estudiante,token);
	}*/
