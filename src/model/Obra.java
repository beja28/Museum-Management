package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class Obra {
	
	private String id;
	private String titulo;
	private String autor;
	private int fecha;
	private Estado estado;
	Calendar fechaActual = new GregorianCalendar(); 
	int anio = fechaActual.get(Calendar. YEAR);
	
	public Obra(String id, String titulo, String autor, int fecha, Estado estado) throws Exception {
		
		if(fecha > anio) {
			throw new IllegalArgumentException();
		}
		else {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.estado = estado;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public JSONObject getState() {
		JSONObject j = new JSONObject();
		j.put("id", id);
		j.put("titulo", titulo);
		j.put("autor", autor);
		j.put("fecha", fecha);
		j.put("estado", estado);
		
		return j;
	}
	
}
