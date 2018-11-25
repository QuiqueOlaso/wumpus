package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

	private int alto;

	private int ancho;

	private Cazador cazador;

	private Wumpus wumpus;
	
	private Oro oro;

	private List<Trampa> trampas;

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public Cazador getCazador() {
		return cazador;
	}

	public void setCazador(Cazador cazador) {
		this.cazador = cazador;
	}

	public Wumpus getWumpus() {
		return wumpus;
	}

	public void setWumpus(Wumpus wumpus) {
		this.wumpus = wumpus;
	}

	public List<Trampa> getTrampas() {
		return trampas;
	}

	public void setTrampas(List<Trampa> trampas) {
		this.trampas = trampas;
	}

	public Tablero(int height, int width) {
		setAlto(height);
		setAncho(width);
	}

	public List<Trampa> setTrampas(int cantidad, int height, int width) {
		if (cantidad <= 0) {
			return null;
		} else {
			List<Trampa> trampasArmadas = new ArrayList<Trampa>();
			for (int i = 0; i <= cantidad; i++) {
				boolean trampaArmada = false;
				Trampa nuevaTrampa;
				while (!trampaArmada) {
					int coordX = TableroHelper.getCoordX(height);
					int coordY = TableroHelper.getCoordY(width);
					nuevaTrampa = new Trampa(i, coordX, coordY);
					if (trampasArmadas.contains(nuevaTrampa)) {
						//
					} else {
						trampaArmada = true;
					}
					trampasArmadas.add(nuevaTrampa);
				}
				return trampasArmadas;
			}
			return trampasArmadas;
		}

	}

}
