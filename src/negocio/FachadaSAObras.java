package negocio;

import java.util.List;

import org.json.JSONObject;

import model.Obra;

public interface FachadaSAObras {
	
		boolean altaObra(JSONObject data);
		
		boolean bajaObra(String id);
		
		List<Obra> consultaObras();
		
		boolean modificaObra(JSONObject data);
}
