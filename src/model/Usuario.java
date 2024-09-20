package model;

public class Usuario {
	private String Nombre;
	private String DNI;
	private String puesto;
	private String contraseña;
	
	
	public Usuario(String nombre, String DNI, String puesto, String contraseña){
		if (DNI.length() == 9) {
		this.Nombre = nombre;
		this.DNI = DNI;
		this.puesto = puesto;
		this.contraseña = contraseña;
		}else {
		}
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return Nombre;
	}

	public String getDNI() {
		// TODO Auto-generated method stub
		return DNI;
	}

	public String getPuesto() {
		// TODO Auto-generated method stub
		return puesto;
	}
	public String getContraseña() {
		// TODO Auto-generated method stub
		return contraseña;
	}

	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		Nombre = nombre;
	}
	public void setPuesto(String puesto) {
		// TODO Auto-generated method stub
		this.puesto = puesto;
	}
	public void setContraseña(String contraseña) {
		// TODO Auto-generated method stub
		this.contraseña = contraseña;
	}
}
