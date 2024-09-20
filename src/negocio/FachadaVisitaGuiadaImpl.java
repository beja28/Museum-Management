package negocio;

import java.util.ArrayList;


import model.*;

public class FachadaVisitaGuiadaImpl implements IFachadaVisitaGuiada{

	private SAVisitaGuiada SA = new SAVisitaGuiadaImpl();
	
	@Override
	public void crearVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
		SA.crearVisita(visita);
	}

	@Override
	public void eliminarVisita(int id_elimina) {
		// TODO Auto-generated method stub
		 SA.eliminarVisita(id_elimina);
	}

	@Override
	public void modificarVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
		 SA.modificarVisita(visita);
	}

	@Override
	public ArrayList<VisitaGuiada> consultarVisitas() {
		// TODO Auto-generated method stub
		return SA.consultarVisitas();
	}


	@Override
	public boolean existeVisita(int id) {
		// TODO Auto-generated method stub
		return SA.existeVisita(id);
	}

}
