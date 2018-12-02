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
		int coordX = 0;
		int coordY = 0;
		this.getWumpus().setCoordX(coordX);
		this.getWumpus().setCoordY(coordY);
	}

	private void randomizePosicionCazador() {
		int coordX = 0;
		int coordY = 0;
		this.getCazador().setCoordX(coordX);
		this.getCazador().setCoordY(coordY);
	}

	private void randomizePosicionOro() {
		int coordX = 0;
		int coordY = 0;
		this.getOro().setCoordX(coordX);
		this.getOro().setCoordY(coordY);
	}

	public void inicializar() {
		this.randomizePosicionWumpus();
		this.randomizePosicionCazador();
		this.randomizePosicionOro();
	}

	public String accion(String operacion) {
		String respuesta = "RESPUESTA NO DEFINIDA";
		if (Constantes.AVANZAR.equals(operacion)) {
			if (Constantes.GIRAR_NORTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordY() > 1) {
					cazador.setCoordY(cazador.getCoordY() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el norte";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar más en la dirección 'norte'";
				}
			} else if (Constantes.GIRAR_SUR.equals(cazador.getEncarado())) {
				if (cazador.getCoordY() > 0 && cazador.getCoordY() < this.getAlto()) {
					cazador.setCoordY(cazador.getCoordY() + 1);
					respuesta = "Hemos avanzado 1 posición hacia el sur";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar más en la dirección 'sur'";
				}
			} else if (Constantes.GIRAR_ESTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1 && cazador.getCoordX() < this.getAncho()) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el este";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar más en la dirección 'este'";
				}
			} else if (Constantes.GIRAR_OESTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el oeste";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar más en la dirección 'oeste'";
				}
			} else {

			}

		} else if (Constantes.GIRAR_NORTE.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.GIRAR_SUR.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.GIRAR_ESTE.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.GIRAR_OESTE.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.SUICIDIO.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.DISPARAR.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.SALIR.equals(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else {
			/* no afecta a la disposicion del tablero */
		}

		return respuesta;
	}

}
