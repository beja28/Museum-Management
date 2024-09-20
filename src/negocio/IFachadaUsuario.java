package negocio;

import java.util.List;

import model.Usuario;

public interface IFachadaUsuario {

	boolean altaUsuario(Usuario u);
	void bajaUsuario(String dni);
	void modificarUsuario(Usuario u);
	public List<Usuario> Usuarios();
	Usuario buscarUsuario(String DNI);
	boolean buscarNombreUsuario(String Nombre);
}
