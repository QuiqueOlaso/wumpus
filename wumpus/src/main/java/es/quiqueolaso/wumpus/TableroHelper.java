/*
 * 
 */
package es.quiqueolaso.wumpus;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroHelper.
 */
public class TableroHelper {

	/** The Constant MIN_COORD. */
	private static final int MIN_COORD = 0;

	/**
	 * Instantiates a new tablero helper.
	 */
	private TableroHelper() {
		/* nothing to do. */
	}

	/**
	 * Gets the coord X.
	 *
	 * @param height the height
	 * @return the coord X
	 */
	public static int getCoordX(int height) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the coord Y.
	 *
	 * @param width the width
	 * @return the coord Y
	 */
	public static int getCoordY(int width) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the respuesta.
	 *
	 * @param tablero   the tablero
	 * @param operacion the operacion
	 * @param cazador   the cazador
	 * @return the respuesta
	 */
	static String getRespuesta(Tablero tablero, String operacion, Cazador cazador) {
		String respuesta = "RESPUESTA NO DEFINIDA";
		if (Constantes.ACCION_AVANZAR.equalsIgnoreCase(operacion)) {
			if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(cazador.getEncarado())) {
				if (cazador.getCoordY() > 1) {
					cazador.setCoordY(cazador.getCoordY() - 1);
					respuesta = "Hemos avanzado 1 posici\u00F3n hacia el norte";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar m\u00e1s en la direcci\u00F3n 'norte'";
				}
			} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(cazador.getEncarado())) {
				if (cazador.getCoordY() > 0 && cazador.getCoordY() < tablero.getAlto()) {
					cazador.setCoordY(cazador.getCoordY() + 1);
					respuesta = "Hemos avanzado 1 posici\u00F3n hacia el sur";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar m\u00e1s en la direcci\u00F3n 'sur'";
				}
			} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1 && cazador.getCoordX() < tablero.getAncho()) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posici\u00F3n hacia el este";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar m\u00e1s en la direcci\u00F3n 'este'";
				}
			} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(cazador.getEncarado())) {
				if (cazador.getCoordX() > 1) {
					cazador.setCoordX(cazador.getCoordX() - 1);
					respuesta = "Hemos avanzado 1 posici\u00F3n hacia el oeste";
				} else {
					respuesta = "Estamos en los limites del tablero. No podemos avanzar m\u00e1s en la direcci\u00F3n 'oeste'";
				}
			} else {

			}

		} else if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_SUICIDIO.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_DISPARAR.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else if (Constantes.ACCION_SALIR.equalsIgnoreCase(operacion)) {
			/* no afecta a la disposicion del tablero */
			respuesta = cazador.accion(operacion);
		} else {
			/* no afecta a la disposicion del tablero */
		}

		return respuesta;
	}

	/**
	 * Gets the random coord.
	 *
	 * @param randomNum the random num
	 * @param max       the max
	 * @return the random coord
	 */
	public static int getRandomCoord(Random randomNum, int max) {
		return MIN_COORD + randomNum.nextInt(max);
	}

}
