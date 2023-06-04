package model;

public class UserClave {
	
	private String usuario;
	private String clave;
	
	public UserClave(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "PruebaPojo [Usuario=" + usuario + ", Clave=" + clave + "]";
	}

	public String getUser() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}
	
	

}
