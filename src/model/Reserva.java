package model;

public class Reserva {
	private String id_reserva;
	private String dni;
	private String id_pista;
	private String dia;
	private String Hora;
	
	public Reserva(String id_reserva, String dni, String id_pista, String dia, String hora) {
		this.id_reserva = id_reserva;
		this.dni = dni;
		this.id_pista = id_pista;
		this.dia = dia;
		Hora = hora;
	}

	public String getId_reserva() {
		return id_reserva;
	}

	public String getDni() {
		return dni;
	}

	public String getId_pista() {
		return id_pista;
	}

	public String getDia() {
		return dia;
	}

	public String getHora() {
		return Hora;
	}
	
	
	
}
