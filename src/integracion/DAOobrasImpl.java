package integracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import model.Estado;
import model.Obra;


public class DAOobrasImpl implements DAOobras{
	
	private List<Obra> listaObras;
	
	public DAOobrasImpl() {
		listaObras = new ArrayList<Obra>();
	}
	
	@Override
	public boolean addObra(Obra obra) {
		return listaObras.add(obra);
	}
	
	@Override
	public Obra buscaObra(String id) {
		Obra o = null;
		boolean encontrado = false;
		int i = 0;
		while(i < listaObras.size() && !encontrado) {
			if(listaObras.get(i).getId().equalsIgnoreCase(id)) {
				encontrado = true;
			}
			else {
				i++;
			}
		}
		if(encontrado) {
			o = listaObras.get(i);
		}
		return o;
	}
	
	@Override
	public boolean eliminarObra(String id) {
		boolean exito = false;
		Obra o = buscaObra(id);
		if(o != null) {
			listaObras.remove(o);
			exito = true;
		}
		
		return exito;
	}
	
	@Override
	public void loadData() {
		InputStream in = null;
		try {
			in = new FileInputStream("datos/obrasRestauracion.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));
		JSONArray obras = jsonInput.getJSONArray("obras");
		JSONObject obra;
		for(int i = 0; i < obras.length(); i++) {
			obra = obras.getJSONObject(i);
			String id = obra.getString("id");
			String titulo = obra.getString("titulo");
			String autor = obra.getString("autor");
			int fecha = obra.getInt("fecha");
			String estado = obra.getString("estado");
			Estado state = Estado.parseToEstado(estado);
			
			Obra o = null;
			try {
				o = new Obra(id, titulo, autor, fecha, state);
				addObra(o);
			} catch (Exception e) {
			}
			
		}
	}
	
	@Override
	public JSONObject getState() {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
		for(Obra o : listaObras) {
			ja.put(o.getState());
		}
		j.put("obras", ja);
		return j;
	}
	
	@Override
	public List<Obra> consultaLista(){
		return Collections.unmodifiableList(listaObras);
	}

	@Override
	public void uploadData() {
		OutputStream out = null;
		try {
			out = new FileOutputStream("datos/obrasRestauracion.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream p = new PrintStream(out);
		
		p.println(getState());
	}
}
