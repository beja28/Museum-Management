package launcher;


import control.Controller;
import model.VisitaGuiada;
import view.MainWindow;
import view.VentanaPrincipalEmpleados;
import view.VisitasPrincipal;

public class Main {
	
	//private static VentanaPrincipal_visitas gui;
	private static MainWindow gui;
	private static VentanaPrincipalEmpleados vent;
	private static VisitasPrincipal visit;
	private static void startGUI() throws Exception {
		
		Controller ctlr = new Controller(); // controlador
		gui = new MainWindow(ctlr);
	}
	
	public static void main(String[] args) {
		try {
			System.getProperty("java.classpath");
			startGUI();
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
	
}
