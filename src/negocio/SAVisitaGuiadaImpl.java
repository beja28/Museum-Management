package negocio;

import java.util.ArrayList;

import integracion.*;
import model.VisitaGuiada;

public class SAVisitaGuiadaImpl implements SAVisitaGuiada {

	FachadaDAOVisitaGuiada FachadaDAO = new FachadaDAOVisitaGuiadaImpl();
	
	@Override
	public void crearVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
			FachadaDAO.insertaVisita(visita);
	}

	@Override
	public void eliminarVisita(int id_elimina) {
		// TODO Auto-generated method stub
			FachadaDAO.eliminarVisita(id_elimina);
	}

	@Override
	public void modificarVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
			FachadaDAO.modificarVisita(visita);
	}

	@Override
	public ArrayList<VisitaGuiada> consultarVisitas() {
		// TODO Auto-generated method stub
		return FachadaDAO.consultarVisitas();
	}

	@Override
	public boolean existeVisita(int id) {
		// TODO Auto-generated method stub
		return FachadaDAO.existeVisita(id);
	}

}
