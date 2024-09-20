package model;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {

	private List<Usuario> usuarios;
	
	public ListaUsuarios() {
		usuarios = new ArrayList<Usuario>();	
	}
	
	boolean altaUsuario(String Nombre, String DNI, String puesto, String contraseña) throws Exception {
		Usuario nuevo = new Usuario(Nombre, DNI, puesto, contraseña);
		for (Usuario u: usuarios) {
			if (u.getDNI() == DNI) {
				throw new Exception();
			}
		}
		try {
			usuarios.add(nuevo);
		}catch(Exception e) {
			throw new Exception("Información invalida" + DNI);
		}
		return true;
	}
	void bajaUsuario(String DNI) throws Exception {
		int i =0;
		boolean encontrado = false;
		while(i< usuarios.size() && !encontrado) {
			if (usuarios.get(i).getDNI() == DNI) {
				usuarios.remove(usuarios.get(i));
				encontrado = true;
			}
		}
		if (encontrado == false) {
			throw new Exception("Usuario inexistente");
		}
	}
	void modificarUsuario(String Nombre, String DNI, String puesto, String contraseña) throws Exception {
		int i =0;
		boolean encontrado = false;
		while(i< usuarios.size() && !encontrado) {
			if (usuarios.get(i).getDNI() == DNI) {
				usuarios.get(i).setNombre(Nombre);
				usuarios.get(i).setPuesto(puesto);
				usuarios.get(i).setContraseña(contraseña);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			throw new Exception("Usuario inexistente");
		}
	}
	public List<Usuario> Usuarios(){
		return usuarios;
	}
	Usuario buscarUsuario(String DNI) throws Exception {
		int i =0;
		boolean encontrado = false;
		while(i< usuarios.size() && !encontrado) {
			if (usuarios.get(i).getDNI() == DNI) {
				encontrado = true;
			}
		}
		if (encontrado == false) {
			throw new Exception("Usuario inexistente");
		}
		return usuarios.get(i);
	}
}
