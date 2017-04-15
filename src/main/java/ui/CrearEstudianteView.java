package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.NotasViewModel;
import ui.vm.CrearEstudianteViewModel;
import model.Estudiante;


public class CrearEstudianteView extends Dialog<CrearEstudianteViewModel> {

	public CrearEstudianteView(WindowOwner owner) {
		super(owner, new CrearEstudianteViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {

		setTitle("Modificar Estudiante");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel tokenPanel = new Panel(mainPanel);
		tokenPanel.setLayout(new HorizontalLayout());

		new Label(tokenPanel).setText("Su Token:").setFontSize(11);
		new TextBox(tokenPanel).setWidth(500).setHeigth(15).bindValueToProperty("token");
		
		Panel apellidoPanel = new Panel(mainPanel);
		apellidoPanel.setLayout(new HorizontalLayout());
		
		new Label(apellidoPanel).setText("Apellido: ").setFontSize(11);
		new TextBox(apellidoPanel).setWidth(500).setHeigth(15).bindValueToProperty("estudianteApellido");

		Panel nombrePanel = new Panel(mainPanel);
		nombrePanel.setLayout(new HorizontalLayout());

		new Label(nombrePanel).setText("Nombre: ").setFontSize(11);
		new TextBox(nombrePanel).setWidth(500).setHeigth(15).bindValueToProperty("estudianteNombre");

		Panel legajoPanel = new Panel(mainPanel);
		legajoPanel.setLayout(new HorizontalLayout());

		new Label(legajoPanel).setText("Legajo: ").setFontSize(11);
		new TextBox(legajoPanel).setWidth(510).setHeigth(15).bindValueToProperty("estudianteLegajo");

		Panel usuarioPanel = new Panel(mainPanel);
		usuarioPanel.setLayout(new HorizontalLayout());

		new Label(usuarioPanel).setText("Usuario de GIT: ").setFontSize(11);
		new TextBox(usuarioPanel).setWidth(460).setHeigth(15).bindValueToProperty("estudianteUsuario");

		getModelObject().obtenerEstudiante();
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->getModelObject().guardarEstudiante()).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

}
