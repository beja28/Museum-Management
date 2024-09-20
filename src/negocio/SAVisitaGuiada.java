package negocio;

import java.util.ArrayList;

import model.VisitaGuiada;

public interface SAVisitaGuiada {

	void crearVisita(VisitaGuiada visita);
	void eliminarVisita(int id_elimina);
	void modificarVisita(VisitaGuiada visita);
	public ArrayList<VisitaGuiada> consultarVisitas();
	public boolean existeVisita(int id);
}
