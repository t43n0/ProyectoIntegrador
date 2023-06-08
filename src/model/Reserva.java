package model;

public class Reserva {
	private String dni;
	private int id_pista;
	private String dia;
	private String Hora;
	
	public Reserva(String dni, int id_pista, String dia, String hora) {
		this.dni = dni;
		this.id_pista = id_pista;
		this.dia = dia;
		Hora = hora;
	}


	public String getDni() {
		return dni;
	}

	public int getId_pista() {
		return id_pista;
	}

	public String getDia() {
		return dia;
	}

	public String getHora() {
		return Hora;
	}
	
	
	
}
