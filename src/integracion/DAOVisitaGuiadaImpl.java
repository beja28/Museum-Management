package integracion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import model.VisitaGuiada;
import view.Utils;

public class DAOVisitaGuiadaImpl implements DAOVisitaGuiada {

	String file = "datos/datosvisitas.json";

	@Override
	public void eliminarVisita(int id_elimina) {
		// TODO Auto-generated method stub
		
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(file);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray visitas = jsonObject.getJSONArray("visitas");
			for (int i = 0; i < visitas.length(); i++) {
				if(id_elimina == visitas.getJSONObject(i).getInt("id")) {
					visitas.remove(i);
				}
			}
			String jsonActualizado = jsonObject.toString();
		    Files.write(Paths.get(file), jsonActualizado.getBytes());
		} catch (FileNotFoundException e) {
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		}
	}

	@Override
	public void modificarVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
		InputStream inputstream;
		String fecha_ant = " ";
		String tematica_ant = " ";
		int duracion_ant = 0;
		try {
	        inputstream = new FileInputStream(file);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray visitas = jsonObject.getJSONArray("visitas");
			for (int i = 0; i < visitas.length(); i++) {
				if(visita.getId() == visitas.getJSONObject(i).getInt("id")) {
					duracion_ant = visitas.getJSONObject(i).getInt("duracion");
					fecha_ant = visitas.getJSONObject(i).getString("fecha");
					tematica_ant = visitas.getJSONObject(i).getString("tematica");
					visitas.remove(i); 
				}
			}
			JSONObject nuevo = new JSONObject();
			nuevo.put("id", visita.getId());
			if(visita.getFecha().equals("")) {
			nuevo.put("fecha", fecha_ant);
			}
			else {
			nuevo.put("fecha", visita.getFecha());
			}
			if(visita.getTematica().equals("")) {
			nuevo.put("tematica", tematica_ant);
			}
			else {
			nuevo.put("tematica", visita.getTematica());
			}
			if(visita.getDuracion() == -1) {
			nuevo.put("duracion", duracion_ant);
			}
			else {
			nuevo.put("duracion", visita.getDuracion());
			}
			visitas.put(nuevo);
			String jsonActualizado = jsonObject.toString();
		    Files.write(Paths.get(file), jsonActualizado.getBytes());
		} catch (FileNotFoundException e) {
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		}
	}

	@Override
	public ArrayList<VisitaGuiada> consultarVisitas() {
		// TODO Auto-generated method stub
		ArrayList<VisitaGuiada> lista = new ArrayList<VisitaGuiada>();
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(file);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray visitas = jsonObject.getJSONArray("visitas");
			for (int i = 0; i < visitas.length(); i++) {
				lista.add(new VisitaGuiada(visitas.getJSONObject(i).getInt("id"), visitas.getJSONObject(i).getString("fecha"),
						visitas.getJSONObject(i).getInt("duracion"), visitas.getJSONObject(i).getString("tematica")));
			}
		} catch (FileNotFoundException e) {
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		}
		
		
		return lista;
	}

	@Override
	public boolean existeVisita(int id) {
		// TODO Auto-generated method stub
		InputStream inputstream;
		boolean ok = true;
		try {
	        inputstream = new FileInputStream(file);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray visitas = jsonObject.getJSONArray("visitas");
	        
			for (int i = 0; i < visitas.length(); i++) {
				if(id == visitas.getJSONObject(i).getInt("id")) {
					ok = false;
				}
			}
		} catch (FileNotFoundException e) {
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		}
		return !ok;
	}

	@Override
	public void insertaVisita(VisitaGuiada visita) {
		// TODO Auto-generated method stub
		JSONObject nuevo = new JSONObject();
		nuevo.put("id", visita.getId());
		nuevo.put("fecha", visita.getFecha());
		nuevo.put("duracion", visita.getDuracion());
		nuevo.put("tematica", visita.getTematica());
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(file);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray visitas = jsonObject.getJSONArray("visitas");
	        visitas.put(nuevo);
	        String jsonActualizado = jsonObject.toString();
	        Files.write(Paths.get(file), jsonActualizado.getBytes());
		} catch (FileNotFoundException e) {
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Utils.showErrorMsg("No se encuentra el archivo JSON");
		}
		
	}

}
