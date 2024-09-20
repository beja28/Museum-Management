package integracion;

import java.util.ArrayList;
import java.util.Date;

import model.VisitaGuiada;

public interface FachadaDAOVisitaGuiada {

	void eliminarVisita(int id_elimina);
	void modificarVisita(VisitaGuiada visita);
	boolean existeVisita(int id);
	public ArrayList<VisitaGuiada> consultarVisitas();
	void insertaVisita(VisitaGuiada visita);
}
