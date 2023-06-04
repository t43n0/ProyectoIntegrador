package model;

public class Puntuacion {
	private int local;
	private int visitante;
	private int tiempoEnSeg;
	
	public Puntuacion(int local, int visitante, int tiempoEnSeg) {
		this.local = local;
		this.visitante = visitante;
		this.tiempoEnSeg = tiempoEnSeg;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public int getVisitante() {
		return visitante;
	}

	public void setVisitante(int visitante) {
		this.visitante = visitante;
	}

	public int getTiempoEnSeg() {
		return tiempoEnSeg;
	}

	public void setTiempoEnSeg(int tiempoEnSeg) {
		this.tiempoEnSeg = tiempoEnSeg;
	}
}
