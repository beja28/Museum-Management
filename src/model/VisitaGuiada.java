package model;


public class VisitaGuiada {
	
	private int id;
	private String fecha;
	private int duracion;
	private String tematica;

	public VisitaGuiada() {};
	
	public VisitaGuiada(int id, String fecha, int duracion, String tematica){
		
		this.id = id;
		this.fecha = fecha;
		this.duracion = duracion;
		this.tematica = tematica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	
	
	
}
