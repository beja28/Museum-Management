package integracion;


import java.util.List;

import org.json.JSONObject;

import model.Obra;

public interface FachadaDAOobras {

	boolean addObra(Obra obra);
	
	Obra buscaObra(String id);
	
	boolean eliminarObra(String id);
	
	JSONObject getState();
	
	List<Obra> consultaLista();
	
	void loadData();
	
	void uploadData();
}
