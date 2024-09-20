package integracion;

import java.util.List;

import model.Usuario;

public interface DAOUsuario {
	
	boolean altaUsuario(String Nombre, String DNI, String puesto, String contraseña);
	void bajaUsuario(String DNI);
	void modificarUsuario(String Nombre, String DNI, String puesto, String contraseña);
	public List<Usuario> Usuarios();
	Usuario buscarUsuario(String DNI);
	boolean buscarNombreUsuario(String Nombre);
}
