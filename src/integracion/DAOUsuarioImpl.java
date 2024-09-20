package integracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario{

	@Override
	public boolean altaUsuario(String Nombre, String DNI, String puesto, String contraseña){
		// TODO Auto-generated method stub
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		
		
		try {
			inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
	        	//Usuario u = new Usuario(Nombre, DNI, puesto, contraseña);
        	JSONObject us = new JSONObject();
        	us.put("Nombre", Nombre);
        	us.put("DNI", DNI);
        	us.put("Puesto", puesto);
        	us.put("Contraseña", contraseña);
        	
        	usuarios.put(us);
        	System.out.println("a");
			String jsonActualizado = jsonObject.toString();
		    Files.write(Paths.get(s), jsonActualizado.getBytes());
            
	            
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void bajaUsuario(String DNI) {
		// TODO Auto-generated method stub
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
			for (int i = 0; i < usuarios.length(); i++) {
				if(DNI.equalsIgnoreCase((String)  usuarios.getJSONObject(i).get("DNI"))) {
					usuarios.remove(i);
				}
			}
			String jsonActualizado = jsonObject.toString();
		    Files.write(Paths.get(s), jsonActualizado.getBytes());
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificarUsuario(String Nombre, String DNI, String puesto, String contraseña) {
		// TODO Auto-generated method stub
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
			for (int i = 0; i < usuarios.length(); i++) {
				if(DNI.equalsIgnoreCase((String) usuarios.getJSONObject(i).get("DNI"))) {
					usuarios.getJSONObject(i).put("Nombre", Nombre);
					usuarios.getJSONObject(i).put("Puesto", puesto);
					usuarios.getJSONObject(i).put("Contraseña", contraseña);
				}
			}
			String jsonActualizado = jsonObject.toString();
		    Files.write(Paths.get(s), jsonActualizado.getBytes());
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> Usuarios() {
		List<Usuario> datos= new ArrayList();
		Usuario aux;
		
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
			for (int i = 0; i < usuarios.length(); i++) {
				aux= new Usuario((String)usuarios.getJSONObject(i).get("Nombre"),
								 (String)usuarios.getJSONObject(i).get("DNI"),
								 (String)usuarios.getJSONObject(i).get("Puesto"),
								 (String)usuarios.getJSONObject(i).get("Contraseña"));
				datos.add(aux);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datos;
	}

	@Override
	public Usuario buscarUsuario(String DNI){
		// TODO Auto-generated method stub
		Usuario u = null;
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
			for (int i = 0; i < usuarios.length(); i++) {
				if(DNI.equalsIgnoreCase((String) usuarios.getJSONObject(i).get("DNI"))) {
					String nombre = (String) usuarios.getJSONObject(i).get("Nombre");
					String puesto = (String) usuarios.getJSONObject(i).get("Puesto");
					String contraseña = (String) usuarios.getJSONObject(i).get("Contraseña");
					
					u = new Usuario (nombre, DNI, puesto, contraseña);
				}
			}
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public boolean buscarNombreUsuario(String Nombre){
		// TODO Auto-generated method stub
		
		String s = "datos/Usuarios.json";
		InputStream inputstream;
		try {
	        inputstream = new FileInputStream(s);
	        JSONObject jsonObject = new JSONObject(new JSONTokener(inputstream));
	        JSONArray usuarios = jsonObject.getJSONArray("Usuarios");
			for (int i = 0; i < usuarios.length(); i++) {
				if(Nombre.equalsIgnoreCase((String) usuarios.getJSONObject(i).get("Nombre"))) {
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
