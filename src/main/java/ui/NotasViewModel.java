package ui;

import model.Asignacion;
import model.Estudiante;
import model.Nota;
import services.RequestService;

import org.uqbar.commons.utils.Observable;
import org.apache.log4j.BasicConfigurator;
import java.util.List;


@Observable
public class NotasViewModel{
	private String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	private RequestService requester;
	private String estudianteApellido, estudianteNombre, estudianteUsuario, asignaturaTitulo, asignaturaDescripcion, textoAsignaturas = "Hola";
	private int estudianteLegajo,asignaturaId;
	List <Asignacion> listaDeAsignaturas;
	
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
		this.updateAsignacion(0);//Código que no se usa
		this.updateTextoAsignaturas();
	}
	
	public void updateAsignacion(int i){//No se usa
		this.asignaturaId = listaDeAsignaturas.get(i).getId();
		this.asignaturaTitulo = listaDeAsignaturas.get(i).getTitulo();
		this.asignaturaDescripcion = listaDeAsignaturas.get(i).getDescription();
	}
	
	public void updateTextoAsignaturas(){
		textoAsignaturas = "";
		
		for(Asignacion asignatura:listaDeAsignaturas){
			textoAsignaturas = textoAsignaturas + this.datosDeAsignatura(asignatura) + "\n";
		}
	}
	
	public String datosDeAsignatura(Asignacion asignatura){
		int id = asignatura.getId();
		String titulo = asignatura.getTitulo();
		String descripcion = asignatura.getDescription();
		List<Nota> notas = asignatura.getNotas();
		
		return "Materia: " + titulo + "   ID: " + id + "   Descripcion: " + descripcion + "   Notas: " + this.procesarNotas(notas);
	}
	
	public String procesarNotas(List<Nota> notas){
		String texto = "";
		
		for(Nota nota:notas){
			texto = texto + this.datosDeNota(nota) + "\n";
		}
		
		return texto;
	}
	
	public String datosDeNota(Nota nota){
		int id = nota.getId();
		String valor = nota.getValor();
		String creado = nota.getCreado();
		String actualizado= nota.getActualizado();
		
		return "ID: " + id + "   Valor: " + valor + "   Creado: " + creado + "   Actualizado: " + actualizado;
	}
	
	//Sustitución de la tabla por label
	
	public String getTextoAsignaturas(){
		return this.textoAsignaturas;
	}
	
	//Getters para la tabla
	public List<Asignacion> getAsignacion(){
		return this.listaDeAsignaturas;
	}
	
	public Asignacion selectedAsignacion(){
		return this.getAsignacion().get(0);//Pongo la primera para probar
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
	
	//Asignaciones Código que no se usa
	
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
	/* Toda la parte de modificar el usiario, desearï¿½a saber cï¿½mo hacerlo en una ventana nueva
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