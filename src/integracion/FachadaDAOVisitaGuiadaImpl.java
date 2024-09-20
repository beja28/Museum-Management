package integracion;

import java.util.ArrayList;
import java.util.Date;

import model.VisitaGuiada;

public class FachadaDAOVisitaGuiadaImpl implements FachadaDAOVisitaGuiada {

	DAOVisitaGuiada DAO = new DAOVisitaGuiadaImpl();
	
	public FachadaDAOVisitaGuiadaImpl() {
		
	}

	@Override
	public void eliminarVisita(int id_elimina) {
		// TODO Auto-generated method stub
	      DAO.eliminarVisita(id_elimina);
	}

	@Override
	public void modificarVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
	     DAO.modificarVisita(visita);
	}

	@Override
	public ArrayList<VisitaGuiada> consultarVisitas() {
		// TODO Auto-generated method stub
		return DAO.consultarVisitas();
	}

	@Override
	public boolean existeVisita(int id) {
		// TODO Auto-generated method stub
		return DAO.existeVisita(id);
	}

	@Override
	public void insertaVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
		DAO.insertaVisita(visita);
	}

}
