package es.quiqueolaso.wumpus;

import java.util.Random;

public class TableroHelper {

	private static final int MIN_COORD = 0;

	private TableroHelper() {
	}

	public static int getCoordX(int height) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getCoordY(int width) {
		// TODO Auto-generated method stub
		return 0;
	}

	static String getRespuesta(Tablero tablero, String operacion, Cazador cazador) {
		String respuesta = "RESPUESTA NO DEFINIDA";
		if (Constantes.AVANZAR.equals(operacion)) {
			if (Constantes.GIRAR_NORTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordY() > 1) {
					cazador.setCoordY(cazador.getCoordY() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el norte";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar mÃ¡s en la dirección 'norte'";
				}
			} else if (Constantes.GIRAR_SUR.equals(cazador.getEncarado())) {
				if (cazador.getCoordY() > 0 && cazador.getCoordY() < tablero.getAlto()) {
					cazador.setCoordY(cazador.getCoordY() + 1);
					respuesta = "Hemos avanzado 1 posición hacia el sur";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar mÃ¡s en la dirección 'sur'";
				}
			} else if (Constantes.GIRAR_ESTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1 && cazador.getCoordX() < tablero.getAncho()) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el este";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar mÃ¡s en la dirección 'este'";
				}
			} else if (Constantes.GIRAR_OESTE.equals(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posición hacia el oeste";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar mÃ¡s en la dirección 'oeste'";
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

	public static int getRandomCoord(Random randomNum, int max) {
		return MIN_COORD + randomNum.nextInt(max);
	}

}
