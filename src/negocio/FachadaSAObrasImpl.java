package negocio;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONObject;

import model.Obra;

public class FachadaSAObrasImpl implements FachadaSAObras{
	private ISAObras sa;
	
	public FachadaSAObrasImpl() {
		sa = new SAObrasImpl();
	}

	@Override
	public boolean altaObra(JSONObject data) {
		return sa.altaObra(data);
	}

	@Override
	public boolean bajaObra(String id) {
		return sa.bajaObra(id);
	}

	@Override
	public List<Obra> consultaObras() {
		return sa.consultaObras();
	}

	@Override
	public boolean modificaObra(JSONObject data) {
		return sa.modificaObra(data);	
	}

	
}
