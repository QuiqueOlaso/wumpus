package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {

	private Random randomNum;

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

	public List<Trampa> setTrampas(int cantidad, int height, int width) {
		if (cantidad <= 0) {
			return null;
		} else {
			List<Trampa> trampasArmadas = new ArrayList<Trampa>();
			for (int i = 0; i <= cantidad; i++) {
				Trampa nuevaTrampa;
				boolean coordenadasReservadas = true;
				int coordX = -1;
				int coordY = -1;
				while (coordenadasReservadas) {
					coordX = TableroHelper.getRandomCoord(randomNum, ancho);
					coordY = TableroHelper.getRandomCoord(randomNum, alto);
					coordenadasReservadas = checkCoordenadasReservadas(coordX, coordY);
				}
				nuevaTrampa = new Trampa(i, coordX, coordY);
				trampasArmadas.add(nuevaTrampa);
			}
			return trampasArmadas;
		}

	}

	public Oro getOro() {
		return oro;
	}

	public void setOro(Oro oro) {
		this.oro = oro;
	}

	public Tablero(int height, int width) {
		setAlto(height);
		setAncho(width);
	}

	private void randomizePosicionWumpus() {
		boolean coordenadasReservadas = true;
		int coordX = -1;
		int coordY = -1;
		while (coordenadasReservadas) {
			coordX = TableroHelper.getRandomCoord(randomNum, ancho);
			coordY = TableroHelper.getRandomCoord(randomNum, alto);
			coordenadasReservadas = checkCoordenadasReservadas(coordX, coordY);
		}
		this.getWumpus().setCoordX(coordX);
		this.getWumpus().setCoordY(coordY);
	}

	private void randomizePosicionCazador() {
		boolean coordenadasReservadas = true;
		int coordX = -1;
		int coordY = -1;
		while (coordenadasReservadas) {
			coordX = TableroHelper.getRandomCoord(randomNum, ancho);
			coordY = TableroHelper.getRandomCoord(randomNum, alto);
			coordenadasReservadas = checkCoordenadasReservadas(coordX, coordY);
		}
		this.getCazador().setCoordX(coordX);
		this.getCazador().setCoordY(coordY);
	}

	private void randomizePosicionOro() {
		boolean coordenadasReservadas = true;
		int coordX = -1;
		int coordY = -1;
		while (coordenadasReservadas) {
			coordX = TableroHelper.getRandomCoord(randomNum, ancho);
			coordY = TableroHelper.getRandomCoord(randomNum, alto);
			coordenadasReservadas = checkCoordenadasReservadas(coordX, coordY);
		}
		this.getOro().setCoordX(coordX);
		this.getOro().setCoordY(coordY);
	}

	private boolean checkCoordenadasReservadas(int coordX, int coordY) {
		boolean respuesta = false;
		if (this.cazador.getCoordX() == coordX && this.cazador.getCoordY() == coordY) {
			respuesta = true;
		} else if (this.wumpus.getCoordX() == coordX && this.wumpus.getCoordY() == coordY) {
			respuesta = true;
		} else if (this.oro.getCoordX() == coordX && this.oro.getCoordY() == coordY) {
			respuesta = true;
		}
		return respuesta;
	}

	public void inicializar() {
		randomNum = new Random();
		this.randomizePosicionWumpus();
		this.randomizePosicionOro();
		this.randomizePosicionCazador();
	}

	public String accion(String operacion) {
		return TableroHelper.getRespuesta(this, operacion, cazador);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sbf = new StringBuilder();
		/* pintamos el tablero base. */
		for (int iii = 0; iii < this.alto; iii++) {
			for (int jjj = 0; jjj < this.ancho; jjj++) {
				if (this.wumpus.getCoordX() == jjj && this.wumpus.getCoordY() == iii) {
					sbf.append("W");
				} else if (this.cazador.getCoordX() == jjj && this.cazador.getCoordY() == iii) {
					sbf.append("C");
				} else if (this.oro.getCoordX() == jjj && this.oro.getCoordY() == iii) {
					sbf.append("G");
				} else {
					sbf.append("·");
				}
			}
			sbf.append("\n");
		}

		return sbf.toString();
	}

}
