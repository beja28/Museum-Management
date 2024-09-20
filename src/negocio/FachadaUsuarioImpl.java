package negocio;

import java.util.List;

import model.Usuario;

public class FachadaUsuarioImpl implements IFachadaUsuario {
	
	private SAUsuario SA = new SAUsuarioImpl();

	@Override
	public boolean altaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return SA.altaUsuario(u);
	}

	@Override
	public void bajaUsuario(String dni) {
		// TODO Auto-generated method stub
		SA.bajaUsuario(dni);
	}

	@Override
	public void modificarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		SA.modificarUsuario(u);
	}

	@Override
	public List<Usuario> Usuarios() {
		// TODO Auto-generated method stub
		return SA.Usuarios();
	}

	@Override
	public Usuario buscarUsuario(String DNI) {
		// TODO Auto-generated method stub
		return SA.buscarUsuario(DNI);
	}

	@Override
	public boolean buscarNombreUsuario(String Nombre) {
		// TODO Auto-generated method stub
		return SA.buscarNombreUsuario(Nombre);
	}

}
