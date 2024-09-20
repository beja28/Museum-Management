package negocio;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import integracion.FachadaDAOobras;
import integracion.FachadaDAOobrasImpl;
import model.Estado;
import model.Obra;

public class SAObrasImpl implements ISAObras{
	
	private FachadaDAOobras dao;
	
	
	public SAObrasImpl() {
		dao = new FachadaDAOobrasImpl();
	}
	
	@Override
	public boolean altaObra(JSONObject data) {
		boolean exito = false;	
		String titulo = null;
		String autor = null;
		int fecha = -1;
		String estado = null;
		Estado state = null;
		try {
		 titulo = data.getString("titulo");
		 autor = data.getString("autor");
		 fecha = data.getInt("fecha");
		 estado = data.getString("estado");
		 state = Estado.parseToEstado(estado);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Informacion insuficiente", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//Gereramos aleatoriamente un id
		
		Random random = new Random();
        int idNum = random.nextInt(1000);
        
        String id = "O-" + idNum;
        while(dao.buscaObra(id) != null) {
        	random = new Random();
            idNum = random.nextInt(1000);
            id = "O-" + idNum;
        }
        
        Obra obra = null;
		try {
			obra = new Obra(id, titulo, autor, fecha, state);
			 //Añadimos la obra 	
	        exito = dao.addObra(obra);
	        
	        
	        if(exito) {
	        	//Actualizamos el JSON
	            dao.uploadData();
	        }
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La fecha introducida es incorrecta", "FECHA INCORRECTA", JOptionPane.ERROR_MESSAGE);
		} 
        
       
        
		return exito;
	}
	
	@Override
	public boolean bajaObra(String id) {
		boolean exito = dao.eliminarObra(id);
		if(exito) {
			dao.uploadData();
		}
		return exito;
	}
	
	@Override
	public List<Obra> consultaObras() {
		return dao.consultaLista();
	}
	
	@Override
	public boolean modificaObra(JSONObject data){
		Calendar fechaActual = new GregorianCalendar(); 
		int anio = fechaActual.get(Calendar. YEAR);
		Obra o = null;
		
		String id = data.getString("id");
		o = dao.buscaObra(id);
		if(id.equals("")){
			JOptionPane.showMessageDialog(null, "El id es null", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String titulo = null;;
		String autor = null;;
		int fecha = -1;
		String estado = null;
		Estado state = null;
		if(o != null) {
			titulo = data.getString("titulo");
			autor = data.getString("autor");
			try {
				fecha = data.getInt("fecha");
			}catch(Exception e) {
				fecha = Integer.MIN_VALUE;
			}
			
			estado = data.getString("estado");
			state = Estado.parseToEstado(estado);
			

			if(titulo != null && !titulo.equals("")) {
				o.setTitulo(titulo);
			}
			if(autor != null && !autor.equals("")) {
				o.setAutor(autor);
			}
			if(fecha > anio) {
				throw new IllegalArgumentException();
			}
			else{
				if(fecha != Integer.MIN_VALUE) {
					o.setFecha(fecha);
				}
			}
			if(state != null) {
				o.setEstado(state);
			}
	
			dao.uploadData();
			return true;
		}
		else {
			return false;
		}
	}
	
}
