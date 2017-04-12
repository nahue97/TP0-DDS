package ui;
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho
//Ese es el token que estoy usando para probar la UI

import java.awt.Color;


import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import model.Asignacion;

@SuppressWarnings("serial")
public class NotasView extends MainWindow<NotasViewModel>{
	
	public NotasView() {
	    super(new NotasViewModel());
	}
	
	@Override
	public void createContents(Panel mainPanel) {
	 
		setTitle("Notas del alumno");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel tokenPanel = new Panel(mainPanel);
		tokenPanel.setLayout(new HorizontalLayout());
		
		new Label(tokenPanel).setText("Ingrese Su Token:").setFontSize(11);
		 
		new TextBox(tokenPanel).setWidth(500).setHeigth(15).bindValueToProperty("token");
	 
		new Button(tokenPanel) //
			.setCaption("Obtener Notas") //
			.onClick(() -> getModelObject().obtenerEstudiante())
			.setFontSize(9)
			.setHeigth(22);
		
		
		Panel apellidoPanel = new Panel(mainPanel);
		apellidoPanel.setLayout(new HorizontalLayout());
		
		new Label(apellidoPanel).setText("Apellido: ").setFontSize(11);
		new Label(apellidoPanel).setFontSize(11).setWidth(100).bindValueToProperty("estudianteApellido");
		
		Panel nombrePanel = new Panel(mainPanel);
		nombrePanel.setLayout(new HorizontalLayout());
	 
		new Label(nombrePanel).setText("Nombre: ").setFontSize(11);
		new Label(nombrePanel).setFontSize(11).setWidth(100).bindValueToProperty("estudianteNombre");
		
		Panel legajoPanel = new Panel(mainPanel);
		legajoPanel.setLayout(new HorizontalLayout());
		
		new Label(legajoPanel).setText("Legajo: ").setFontSize(11);
		new Label(legajoPanel).setFontSize(11).setWidth(100).bindValueToProperty("estudianteLegajo");
		
		Panel usuarioPanel = new Panel(mainPanel);
		usuarioPanel.setLayout(new HorizontalLayout());
	 
		new Label(usuarioPanel).setText("Usuario de GIT: ").setFontSize(11);
		new Label(usuarioPanel).setFontSize(11).setWidth(100).bindValueToProperty("estudianteUsuario");
	 
		new Label(mainPanel).setText("Asignaturas: ");
		
		//DATOS ASIGNATURA DE PRUEBA	 
		/*new Label(mainPanel).bindValueToProperty("asignaturaId");
		
		new Label(mainPanel).bindValueToProperty("asignaturaTitulo");
		
		new Label(mainPanel).bindValueToProperty("asignaturaDescripcion");*/
		
		new Label(mainPanel).setHeigth(30).bindValueToProperty("textoAsignaturas");//El label se va a encargar de mostrar las cosas
																	// ya que la tabla no sale
		
		
		//Tabla Fallida
		/*Table<Asignacion> tableAsignaturas = new Table<>(mainPanel, Asignacion.class);
		
		tableAsignaturas.bindItemsToProperty("asignacion");
		
		tableAsignaturas.bindValueToProperty("selectedAsignacion");
			Column<Asignacion> columnaId = new Column<Asignacion>(tableAsignaturas);
				columnaId.setTitle("Id");
				columnaId.setFixedSize(50);
				columnaId.bindContentsToProperty("asignaturaId");
		
				Column<Asignacion> columnaTitulo = new Column<Asignacion>(tableAsignaturas);
				columnaTitulo.setTitle("Titulo");
				columnaId.bindContentsToProperty("asignaturaTitulo");
		
			Column<Asignacion> columnaDescripcion = new Column<Asignacion>(tableAsignaturas);
				columnaDescripcion.setTitle("Descripcion");
				columnaId.bindContentsToProperty("asignaturaDescripcion");
				
			//Las notas las dejamos para después, primero que salga todo lo otro
			//Column<Asignacion> columnaNotas = new Column<Asignacion>(tableAsignaturas);
			//	columnaNotas.setTitle("Notas");
			//	columnaId.bindContentsToProperty("asignaturaNotas");
				
		tableAsignaturas.setHeigth(300);
		tableAsignaturas.setWidth(1000);*/
	}
	
	public static void main(String[] args) {
		new NotasView().startApplication();
	}
	
}