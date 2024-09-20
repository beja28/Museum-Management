package control;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

//import model.ListaVisitasGuiadas;
import model.Obra;
import model.Usuario;
import model.VisitaGuiada;
import negocio.FachadaSAObrasImpl;
import negocio.FachadaUsuarioImpl;
import negocio.FachadaVisitaGuiadaImpl;
import negocio.IFachadaUsuario;

import view.*;

public class Controller {
	
	VisitasPrincipal gui;
	//ListaVisitasGuiadas lvg;
	FachadaVisitaGuiadaImpl fvg;
	IFachadaUsuario fus;
	FachadaSAObrasImpl sa;
	

	public Controller() {
		// TODO Auto-generated constructor stub
		//gui = this.gui;
		sa = new FachadaSAObrasImpl();
		fvg = new FachadaVisitaGuiadaImpl();
		fus = new FachadaUsuarioImpl();
	}
	
	public ArrayList<VisitaGuiada> consultarVisitas() {
		// TODO Auto-generated method stub
		return fvg.consultarVisitas();
	}
	
	public void modificarVisita(VisitaGuiada visita) {
		fvg.modificarVisita(visita);
	}
	
	public void crearVisita(VisitaGuiada visita) {
		fvg.crearVisita(visita);
	}

	public void eliminarVisita(int id_elimina) {
		// TODO Auto-generated method stub
		fvg.eliminarVisita(id_elimina);
	}
	
	public boolean existeVisita(int id) {
		return fvg.existeVisita(id);
	}
	
	

	public boolean altaUsuario(Usuario u) {
		return fus.altaUsuario(u);
	}
	
	public void bajaUsuario(String dni) {
		fus.bajaUsuario(dni);
	}
	
	public void modificarUsuario(Usuario u) {
		fus.modificarUsuario(u);
	}
	
	public List<Usuario> Usuarios() {
		
		return fus.Usuarios();
	}
	public Usuario buscarUsuario(String DNI){
		
		return fus.buscarUsuario(DNI);
	}
	public boolean buscarNombreUsuario(String Nombre) {
		return fus.buscarNombreUsuario(Nombre);
	}
	
	
	public boolean altaObra(JSONObject data) {
		return sa.altaObra(data);
	
	}

	public boolean bajaObra(String id) {
		return sa.bajaObra(id);
	}

	public List<Obra> consultaObras() {
		return sa.consultaObras();
	}

	public boolean modificaObra(JSONObject data) {
		return sa.modificaObra(data);	
	}

}
