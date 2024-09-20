package negocio;

import java.util.*;

import model.VisitaGuiada;

public interface IFachadaVisitaGuiada {

	void crearVisita(VisitaGuiada visita);
	void modificarVisita(VisitaGuiada visita);
	public ArrayList<VisitaGuiada> consultarVisitas();
	void eliminarVisita(int id_elimina);
	public boolean existeVisita(int id);
}
