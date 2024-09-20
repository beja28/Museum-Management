package model;

import java.util.ArrayList;
import java.util.List;


public class ListaVisitasGuiadas {
	
	private List<VisitaGuiada> visitas;
	
	public ListaVisitasGuiadas() {
		
		visitas = new ArrayList<VisitaGuiada>();
		
	}
	
	void creaVisita(VisitaGuiada v) {
		
		if (v == null) {
			throw new IllegalArgumentException();
		}
		for (VisitaGuiada vs : visitas) {
			if (v.getId() == vs.getId()) {
				throw new IllegalArgumentException();
			}
		}
		
		visitas.add(v);
		
	}
	
	void eliminaVisita(int id) {
		
		for (VisitaGuiada vs : visitas) {
			if(vs.getId() == id) {
				visitas.remove(vs);
			}
		}
		
	}
	
	VisitaGuiada buscaVisita(int id) throws Exception {
		for (VisitaGuiada vs : visitas) {
			if(vs.getId() == id) {
				return vs;
			}
		}
		throw new Exception("No existe una visita guiada con el id introducido");
	}
	
	void modificaVisita (int id) {
		
	}
	
	void consultarVisitas() {
	}

}
