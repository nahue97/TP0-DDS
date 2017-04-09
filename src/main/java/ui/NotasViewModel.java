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
	Asignaciones asignaciones = new Asignaciones();
	private String token, estudianteApellido, estudianteUsuario, textoAsignaciones;
	private int estudianteLegajo;
	
	public void setUp(){
		this.requester = new RequestService();
		BasicConfigurator.configure();
	}
	
	public void obtenerEstudiante() {
		this.setUp();
		
		Estudiante estudiante = this.requester.getStudentByToken(token);
		
		estudianteLegajo = estudiante.getLegajo();
		estudianteApellido = estudiante.getApellido();
		estudianteUsuario = estudiante.getUsuarioGithub();
		asignaciones = this.requester.getAssignmentsForStudent(token);
	}
	
	//getters
	public int getEstudianteLegajo(){
		return this.estudianteLegajo;
	}
	public String getEstudianteApellido(){
		return this.estudianteApellido;
	}
	public String getEstudianteUsuario(){
		return this.estudianteUsuario;
	}
	public String getToken(){
		return this.token;
	}
	public String getTextoAsignaciones(){//Decidí convertir las asignaciones en texto porque no sabría muy bien como hacerlo de otra manera más elegante
		List <Asignacion> listaAsignaciones = asignaciones.getAsignaciones();
		textoAsignaciones = "";
		
		for(Asignacion asig: listaAsignaciones){
			textoAsignaciones = textoAsignaciones + asig.getTitulo(); //Quiero que retorne los títulos solamente para probar, pero la la bel está siempre vacía
		}
		return textoAsignaciones;
	}
	
	//setters
	public void setToken(String unToken){
		this.token = unToken;
	}
	/* Toda la parte de modificar el usiario, desearía saber cómo hacerlo en una ventana nueva
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