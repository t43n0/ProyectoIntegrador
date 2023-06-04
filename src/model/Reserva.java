package model;

public class Reserva {
	private String nombre;
	private String pista;
	private Puntuacion puntos;
	private Date fecha;
	
	public Reserva(String nombre, String pista, Puntuacion puntos, Date fecha) {
		this.nombre = nombre;
		this.pista = pista;
		this.puntos = puntos;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPista() {
		return pista;
	}

	public Puntuacion getPuntos() {
		return puntos;
	}

	public Date getFecha() {
		return fecha;
	}
}
