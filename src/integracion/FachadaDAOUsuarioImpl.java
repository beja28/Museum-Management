package integracion;

import java.util.List;

import model.Usuario;

public class FachadaDAOUsuarioImpl implements FachadaDAOUsuario {
	
	DAOUsuario DAO = new DAOUsuarioImpl();
	
	public FachadaDAOUsuarioImpl() {
		
	}

	@Override
	public boolean altaUsuario(String Nombre, String DNI, String puesto, String contraseña){
		// TODO Auto-generated method stub
		return DAO.altaUsuario(Nombre, DNI, puesto, contraseña);
	}

	@Override
	public void bajaUsuario(String DNI) {
		// TODO Auto-generated method stub
		DAO.bajaUsuario(DNI);
	}

	@Override
	public void modificarUsuario(String Nombre, String DNI, String puesto, String contraseña) {
		// TODO Auto-generated method stub
		DAO.modificarUsuario(Nombre, DNI, puesto, contraseña);
	}

	@Override
	public List<Usuario> Usuarios() {
		// TODO Auto-generated method stub
		return DAO.Usuarios();
	}

	@Override
	public Usuario buscarUsuario(String DNI){
		// TODO Auto-generated method stub
		return DAO.buscarUsuario(DNI);
	}

	@Override
	public boolean buscarNombreUsuario(String Nombre) {
		// TODO Auto-generated method stub
		return DAO.buscarNombreUsuario(Nombre);
	}

}
