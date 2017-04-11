package ui;

import model.Asignacion;
import model.Asignaciones;
import model.Estudiante;
import services.RequestService;

import org.uqbar.commons.utils.Observable;
import org.apache.log4j.BasicConfigurator;
import java.util.List;


@Observable
public class NotasViewModel{
	
	private RequestService requester;
	private Asignaciones asignaciones = new Asignaciones();
	private String token, estudianteApellido, estudianteNombre, estudianteUsuario, asignaturaTitulo, asignaturaDescripcion;
	private int estudianteLegajo,asignaturaId;
	
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
		asignaciones = this.requester.getAssignmentsForStudent(token);
		this.updateAsignacion();
	}
	
	public void updateAsignacion(){
		this.asignaturaId = asignaciones.getAsignaciones().get(0).getId();
		this.asignaturaTitulo = asignaciones.getAsignaciones().get(0).getTitulo();
		this.asignaturaDescripcion = asignaciones.getAsignaciones().get(0).getDescription();
	}
	
	//getters
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
	public int getAsignaturaId(){
		return this.asignaturaId;
	}
	public String getAsignaturaTitulo(){
		return this.asignaturaTitulo;
	}
	public String getAsignaturaDescripcion(){
		return this.asignaturaDescripcion;
	}
	
	//setters
	public void setToken(String unToken){
		this.token = unToken;
	}
	/* Toda la parte de modificar el usiario, desear�a saber c�mo hacerlo en una ventana nueva
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
	
}