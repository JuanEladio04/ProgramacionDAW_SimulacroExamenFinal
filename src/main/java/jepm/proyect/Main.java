package jepm.proyect;

import jepm.proyect.controller.ArtistaController;
import jepm.proyect.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		ArtistaController.getInstance().findAll();
		MainWindow.main(args);
	}

}
