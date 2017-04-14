import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ui.NotasView;

public class NotasApplication extends Application{

	public static void main(String[] args) {
		new NotasApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new NotasView(this);
	}
}
