package model;

public class UserData {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private String telefono;
	private String direccion;
	
	
	public UserData(String dni, String nombre, String apellido, String email, String contrasenia, String telefono,
			String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getEmail() {
		return email;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getDireccion() {
		return direccion;
	}
	
	
	
	

}
