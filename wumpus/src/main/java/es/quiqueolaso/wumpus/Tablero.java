package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.quiqueolaso.wumpus.utils.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class Tablero.
 */
public class Tablero {

	/** The random num. */
	private Random randomNum;

	/** The alto. */
	private int alto;

	/** The ancho. */
	private int ancho;

	/** The cazador. */
	private Cazador cazador;

	/** The wumpus. */
	private Wumpus wumpus;

	/** The oro. */
	private Oro oro;

	/** The trampas. */
	private List<Trampa> trampas;

	/*
	 * *************************** GETTERS / SETTERS ***************************
	 */

	/**
	 * Gets the alto.
	 *
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Sets the alto.
	 *
	 * @param alto the new alto
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * Gets the ancho.
	 *
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Sets the ancho.
	 *
	 * @param ancho the new ancho
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * Gets the cazador.
	 *
	 * @return the cazador
	 */
	public Cazador getCazador() {
		return cazador;
	}

	/**
	 * Sets the cazador.
	 *
	 * @param cazador the new cazador
	 */
	public void setCazador(Cazador cazador) {
		this.cazador = cazador;
	}

	/**
	 * Gets the wumpus.
	 *
	 * @return the wumpus
	 */
	public Wumpus getWumpus() {
		return wumpus;
	}

	/**
	 * Sets the wumpus.
	 *
	 * @param wumpus the new wumpus
	 */
	public void setWumpus(Wumpus wumpus) {
		this.wumpus = wumpus;
	}

	/**
	 * Gets the trampas.
	 *
	 * @return the trampas
	 */
	public List<Trampa> getTrampas() {
		return trampas;
	}

	/**
	 * Sets the trampas.
	 *
	 * @param trampas the new trampas
	 */
	public void setTrampas(List<Trampa> trampas) {
		this.trampas = trampas;
	}

	/**
	 * Gets the oro.
	 *
	 * @return the oro
	 */
	public Oro getOro() {
		return oro;
	}

	/**
	 * Sets the oro.
	 *
	 * @param oro the new oro
	 */
	public void setOro(Oro oro) {
		this.oro = oro;
	}

	/*
	 * *************************** CONSTRUCTOR ***************************
	 */

	/**
	 * Instantiates a new tablero.
	 *
	 * @param height the height
	 * @param width  the width
	 */
	public Tablero(int height, int width) {
		setAlto(height);
		setAncho(width);
	}

	/*
	 * *************************** MAIN METHODS ***************************
	 */

	/**
	 * Inicializar.
	 */
	public void inicializar() {
		randomNum = new Random();
		this.randomizePosicionWumpus();
		this.randomizePosicionOro();
		this.randomizePosicionCazador();
	}

	/**
	 * Sets the trampas.
	 *
	 * @param cantidad the cantidad
	 * @param height   the height
	 * @param width    the width
	 * @return the list
	 */
	public void inicializarTrampas(int cantidad, int height, int width) {
		if (cantidad <= 0) {
			/* nothing to do. */
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
			this.setTrampas(trampasArmadas);
		}
	}

	/**
	 * Accion.
	 *
	 * @param operacion the operacion
	 * @return the string
	 */
	public String accion(String operacion) {
		return TableroHelper.getRespuesta(this, operacion, cazador);
	}

	/**
	 * Reaccion.
	 *
	 * @return the string
	 */
	public String reaccion() {
		StringBuilder sbr = new StringBuilder();
		if (this.checkDistanciaWumpus() == 0) {
			sbr.append("El cazador se encuentra en la misma casilla que el Wumpus!");
			if (this.getWumpus().isAlive()) {
				sbr.append(
						"Lamentablemente, el Wumpus ha logrado acechar con éxito al Cazador, y éste ha fallecido...");
			}
			sbr.append("\n");
		} else if (this.checkDistanciaWumpus() == 1) {
			sbr.append("El cazador percibe el hedor del Wumpus ...");
			sbr.append("\n");
		}
		if (this.checkDistanciaOro() == 0) {
			sbr.append("El cazador se encuentra en la misma casilla que el Oro!");
			sbr.append("\n");
		} else if (this.checkDistanciaOro() == 1) {
			sbr.append("El cazador percibe el brillo del Oro ...");
			sbr.append("\n");
		}
		if (this.checkDistanciaTrampas() == 0) {
			sbr.append("El cazador se encuentra en la misma casilla que una de las trampas!");
			sbr.append("\n");
		} else if (this.checkDistanciaTrampas() == 1) {
			sbr.append("El cazador percibe una ligera brisa que parece provenir de alguna trampa cercana ...");
			sbr.append("\n");
		}

		if (!this.getWumpus().isAlive()) {
			sbr.append("El cazador oye el grito de dolor del Wumpus: Lo ha abatido!!");
			sbr.append("\n");
		}
		return sbr.toString();

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
		for (int yyy = 0; yyy < this.alto; yyy++) {
			for (int xxx = 0; xxx < this.ancho; xxx++) {
				if (this.wumpus.getCoordX() == xxx && this.wumpus.getCoordY() == yyy) {
					sbf.append(Constantes.LEYENDA_WUMPUS); /* W. */
				} else if (this.cazador.getCoordX() == xxx && this.cazador.getCoordY() == yyy) {
					if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_NORTE);
					} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_SUR);
					} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_ESTE);
					} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_OESTE);
					} else {
						Log.debug("cazador.getEncarado()=" + cazador.getEncarado());
						sbf.append(Constantes.LEYENDA_CAZADOR_DESCONOCIDO);
					}
				} else if (this.oro.getCoordX() == xxx && this.oro.getCoordY() == yyy) {
					sbf.append(Constantes.LEYENDA_ORO); /* G. */
				} else {
					sbf.append(Constantes.LEYENDA_CASILLA); /* middle dot. */
				}
				if (this.getTrampas() != null) {
					for (Trampa trampa : this.getTrampas()) {
						if (trampa.getCoordX() == xxx && trampa.getCoordY() == yyy) {
							sbf.append(Constantes.LEYENDA_TRAMPA); /* asterisk. */
						}
					}
				}

			}
			sbf.append("\n");
		}

		return sbf.toString();
	}

	/*
	 * *************************** AUX METHODS ***************************
	 */

	/**
	 * Randomize posicion cazador.
	 */
	private void randomizePosicionCazador() {
		boolean coordenadasReservadas = true;
		boolean lejaniaWumpus = true;
		boolean lejaniaOro = true;
		int coordX = -1;
		int coordY = -1;
		while (coordenadasReservadas && lejaniaWumpus && lejaniaOro) {
			coordX = TableroHelper.getRandomCoord(randomNum, ancho);
			coordY = TableroHelper.getRandomCoord(randomNum, alto);
			coordenadasReservadas = checkCoordenadasReservadas(coordX, coordY);
			lejaniaWumpus = checkDistanciaInicialWumpus();
			lejaniaOro = checkDistanciaInicialOro();
		}
		this.getCazador().setCoordX(coordX);
		this.getCazador().setCoordY(coordY);
	}

	/**
	 * Randomize posicion oro.
	 */
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

	/**
	 * Randomize posicion wumpus.
	 */
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

	/**
	 * Check coordenadas reservadas.
	 *
	 * @param coordX the coord X
	 * @param coordY the coord Y
	 * @return true, if successful
	 */
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

	/**
	 * Check distancia inicial wumpus.
	 *
	 * @return true, if successful
	 */
	protected boolean checkDistanciaInicialWumpus() {
		boolean respuesta = false;
		int distanciaX = java.lang.Math.abs(this.getCazador().getCoordX() - this.getWumpus().getCoordX());
		int distanciaY = java.lang.Math.abs(this.getCazador().getCoordY() - this.getWumpus().getCoordY());
		if (distanciaX >= this.getAncho() / 2 && distanciaY >= this.getAlto() / 2) {
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * Check distancia wumpus.
	 *
	 * @return the int
	 */
	protected int checkDistanciaWumpus() {
		int respuesta = -1;
		int distanciaX = java.lang.Math.abs(this.getCazador().getCoordX() - this.getWumpus().getCoordX());
		int distanciaY = java.lang.Math.abs(this.getCazador().getCoordY() - this.getWumpus().getCoordY());
		if (distanciaX == 0 && distanciaY == 0) {
			respuesta = 0;
		} else if (distanciaX == 1 || distanciaY == 1) {
			respuesta = 1;
		}
		return respuesta;
	}

	/**
	 * Check distancia inicial oro.
	 *
	 * @return true, if successful
	 */
	protected boolean checkDistanciaInicialOro() {
		boolean respuesta = false;
		int separacionX = java.lang.Math.abs(this.getCazador().getCoordX() - this.getOro().getCoordX());
		int separacionY = java.lang.Math.abs(this.getCazador().getCoordY() - this.getOro().getCoordY());
		if (separacionX >= this.getAncho() / 2 && separacionY >= this.getAlto() / 2) {
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * Check distancia oro.
	 *
	 * @return the int
	 */
	protected int checkDistanciaOro() {
		int respuesta = -1;
		int distanciaX = java.lang.Math.abs(this.getCazador().getCoordX() - this.getOro().getCoordX());
		int distanciaY = java.lang.Math.abs(this.getCazador().getCoordY() - this.getOro().getCoordY());
		if (distanciaX == 0 && distanciaY == 0) {
			respuesta = 0;
		} else if (distanciaX == 1 || distanciaY == 1) {
			respuesta = 1;
		}
		return respuesta;
	}

	/**
	 * Check distancia trampas.
	 *
	 * @return the int
	 */
	protected int checkDistanciaTrampas() {
		int respuesta = -1;
		int nTrampas = 0;
		while (respuesta == -1 && nTrampas < this.getTrampas().size()) {
			respuesta = checkDistanciaTrampaIndividual(this.getTrampas().get(nTrampas));
			nTrampas++;
		}
		return respuesta;
	}

	/**
	 * Check distancia trampa individual.
	 *
	 * @param trampa the trampa
	 * @return the int
	 */
	private int checkDistanciaTrampaIndividual(Trampa trampa) {
		int respuesta = -1;
		int distanciaX = java.lang.Math.abs(this.getCazador().getCoordX() - trampa.getCoordX());
		int distanciaY = java.lang.Math.abs(this.getCazador().getCoordY() - trampa.getCoordY());
		Log.trace(" * cazador=" + cazador.toString());
		Log.trace(" * trampa=" + trampa.toString());
		Log.trace(" * distanciaX=" + distanciaX);
		Log.trace(" * distanciaY=" + distanciaY);
		if (distanciaX == 0 && distanciaY == 0) {
			respuesta = 0;
		} else if (distanciaX == 1 || distanciaY == 1) {
			respuesta = 1;
		}
		return respuesta;
	}

}
