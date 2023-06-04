package model;

public class Date {
	private int hora;
	private int minuto;
	private int dia;
	private int mes;
	
	public Date(int mes, int dia, int hora, int minuto) {
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}
	
}
