package negocio;

import java.util.List;

import org.json.JSONObject;

import model.Obra;

public interface ISAObras {
	
	boolean altaObra(JSONObject data);
	
	boolean bajaObra(String id);
	
	List<Obra> consultaObras();
	
	boolean modificaObra(JSONObject data);
}
