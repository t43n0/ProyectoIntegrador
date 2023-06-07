package model;

public class UserData {
	private String nombre;
	private String apellidos;
	private String dni;
	private String ciudad;
	private String clave;
	
	
	public UserData(String nombre, String apellidos, String dni, String ciudad, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.ciudad = ciudad;
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getClave() {
		return clave;
	}
}
