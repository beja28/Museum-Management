package negocio;

import java.util.List;

import integracion.FachadaDAOUsuario;
import integracion.FachadaDAOUsuarioImpl;
import integracion.FachadaDAOVisitaGuiada;
import integracion.FachadaDAOVisitaGuiadaImpl;
import model.Usuario;
import model.VisitaGuiada;

public class SAUsuarioImpl implements SAUsuario{
	
	FachadaDAOUsuario FachadaDAO = new FachadaDAOUsuarioImpl();

	@Override
	public boolean altaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		if (FachadaDAO.buscarUsuario(u.getDNI()) != null) {
			return false;
		}else {
			FachadaDAO.altaUsuario(u.getNombre(), u.getDNI(), u.getPuesto(), u.getContraseña());
		}
		return true;
	}
	
	@Override
	public void bajaUsuario(String dni) {
		// TODO Auto-generated method stub
		if (FachadaDAO.buscarUsuario(dni) != null) {
			FachadaDAO.bajaUsuario(dni);
			
		}else {
			System.out.println("Este usuario no existe");
		}
	}

	@Override
	public void modificarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		if (FachadaDAO.buscarUsuario(u.getDNI()) != null) {
			FachadaDAO.modificarUsuario(u.getNombre(), u.getDNI(), u.getPuesto(), u.getContraseña());
			
		}else {
			System.out.println("Este usuario no existe");
		}
	}

	@Override
	public List<Usuario> Usuarios() {
		// TODO Auto-generated method stub
		return FachadaDAO.Usuarios();
	}

	@Override
	public Usuario buscarUsuario(String DNI) {
		// TODO Auto-generated method stub
		return FachadaDAO.buscarUsuario(DNI);
	}

	@Override
	public boolean buscarNombreUsuario(String Nombre) {
		// TODO Auto-generated method stub
		return FachadaDAO.buscarNombreUsuario(Nombre);
	}

}
