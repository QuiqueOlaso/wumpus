package es.quiqueolaso.wumpus.utils;

import es.quiqueolaso.wumpus.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class Log.
 */
public class Log {

	/**
	 * Debug.
	 *
	 * @param message the message
	 */
	public static void debug(String message) {
		if (Constantes.DEBUG) {
			log(message);
		}
	}

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void info(String message) {
		log(message);
	}

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	private static void log(String message) {
		System.out.println(message);
	}

}
