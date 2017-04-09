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
import org.uqbar.arena.windows.MainWindow;

@SuppressWarnings("serial")
public class NotasView extends MainWindow<NotasViewModel>{
	
	public NotasView() {
	    super(new NotasViewModel());
	}
	
 @Override
 public void createContents(Panel mainPanel) {
	 
	 setTitle("Notas del alumno");
	 mainPanel.setLayout(new VerticalLayout());
	 
	 new Label(mainPanel).setText("Ingrese Su Token");
		 
	 new TextBox(mainPanel).bindValueToProperty("token");
	 
	 new Button(mainPanel) //
	 .setCaption("Obtener Notas") //
	 .onClick(() -> getModelObject().obtenerEstudiante());
	 
	 new Label(mainPanel).setText("Apellido");
	 
	 new Label(mainPanel).bindValueToProperty("estudianteApellido");
	 
	 new Label(mainPanel).setText("Legajo");
	 
	 new Label(mainPanel).bindValueToProperty("estudianteLegajo");
	 
	 new Label(mainPanel).setText("Usuario de GIT");
	 //Me gustaría saber cómo implementar un layout vertical para estas dos Label se que
	 //deberían estar dentro de otro Panel pero no se muy bien cómo integrarlo al mainPanel
	 new Label(mainPanel).bindValueToProperty("estudianteUsuario");
	 
	 new Label(mainPanel).setText("Asignaturas");
	 
	 new Label(mainPanel).bindValueToProperty("textoAsignaciones"); //Debería encargarse de los detalles de las asignaciones
 }
 
 
 public static void main(String[] args) {
	 new NotasView().startApplication();
	 }
}