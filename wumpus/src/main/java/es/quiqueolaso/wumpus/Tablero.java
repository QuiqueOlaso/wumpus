package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
					// sbf.append("\u0043"); /* C. */
					if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_NORTE);
					} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_SUR);
					} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_ESTE);
					} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(cazador.getEncarado())) {
						sbf.append(Constantes.LEYENDA_CAZADOR_OESTE);
					} else {
						JuegoHelper.log("cazador.getEncarado()=" + cazador.getEncarado());
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

}
