package es.quiqueolaso.wumpus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Auto-generated Javadoc
/**
 * The Class JuegoHelper.
 */
public class JuegoHelper {

	/**
	 * Checks if is operacion sistema.
	 *
	 * @param operacion the operacion
	 * @return true, if is operacion sistema
	 */
	protected static boolean isOperacionSistema(String operacion) {
		if (Constantes.RESET_PARTIDA.equals(operacion) || Constantes.SALIR_PARTIDA.equals(operacion)) {
			return true;
		} else {
			return false;
		}
	}

	static void log(String message) {
		System.out.println(message);
	}

	/**
	 * Prints the controles.
	 */
	static void printControles() {
		log(" --------------------------");
		log("Controles:");
		log(" * 'N' encarar al norte");
		log(" * 'S' encarar al sur");
		log(" * 'W' encarar al oeste");
		log(" * 'E' encarar al este");
		log(" * 'A' avanzar");
		log(" * 'F' disparar");
		log(" * 'M' salir del bosque");
		log(" --------------------------");
		log(" * 'Q' abandonar el juego");
		log(" * 'R' reiniciar el juego");
	}

	/**
	 * Prints the dialogo inicial.
	 *
	 * @return the string
	 */
	static void printDialogoInicial() {
		log("Eres el cazador.");
		log("Te encuentras en un bosque");
		log("Puedes avanzar en todas direcciones, pero \u00a1cuidado! hay trampas");
		log("... y el Wumpus est\u00e1 al acecho");
	}

	/**
	 * Prints the dialogo turno.
	 *
	 * @return the string
	 */
	static String printDialogoTurno() {
		printControles();
		return leerRespuesta();
	}

	/**
	 * Leer respuesta.
	 *
	 * @return the string
	 */
	static String leerRespuesta() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String operacion = null;
		try {
			operacion = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return operacion;
	}

	static void printPosicionCazadorRespectoTablero(Tablero tablero) {
		String encarado = tablero.getCazador().getEncarado();
		int coordX = tablero.getCazador().getCoordX();
		int coordY = tablero.getCazador().getCoordY();
		int ancho = tablero.getAncho() - 1;
		int alto = tablero.getAlto() - 1;

		/* 0,0. */
		if (coordX == 0 && coordY == 0 && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde nor-occidental del bosque, con el linde del mismo a tu izquierda y frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
		} else if (coordX == 0 && coordY == 0 && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde nor-occidental del bosque, con el linde del mismo a tu derecha y espalda");
		} else if (coordX == 0 && coordY == 0 && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde nor-occidental del bosque, con el linde del mismo a tu izquierda y espalda");
		} else if (coordX == 0 && coordY == 0 && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde nor-occidental del bosque, con el linde del mismo a tu derecha y frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
			/* MAX,MAX. */
		} else if (coordX >= ancho && coordY >= alto && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde sud-oriental del bosque, con el linde del mismo a tu derecha y espalda");
		} else if (coordX >= ancho && coordY >= alto && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde sud-oriental del bosque, con el linde del mismo a tu izquierda y frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
		} else if (coordX >= ancho && coordY >= alto && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde sud-oriental del bosque, con el linde del mismo a tu derecha y frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
		} else if (coordX >= ancho && coordY >= alto && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde sud-oriental del bosque, con el linde del mismo a tu izquierda y espalda");
			/* 0, ?. */
		} else if (coordX == 0 && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde occidental del bosque, con el linde del mismo a tu izquierda");
		} else if (coordX == 0 && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde occidental del bosque, con el linde del mismo a tu derecha");
		} else if (coordX == 0 && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde occidental del bosque, con el linde del mismo a tu espalda");
		} else if (coordX == 0 && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde occidental del bosque, con el linde del mismo frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
			/* MAX, ?. */
		} else if (coordX >= ancho && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde oriental del bosque, con el linde del mismo a tu derecha");
		} else if (coordX >= ancho && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde oriental del bosque, con el linde del mismo a tu izquierda");
		} else if (coordX >= ancho && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde oriental del bosque, con el linde del mismo frente a ti");
		} else if (coordX >= ancho && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde oriental del bosque, con el linde del mismo a tu espalda");
			/* ?, 0. */
		} else if (coordY == 0 && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde norte del bosque, con el linde del mismo frente a ti");
			log("Si quieres salir, presiona " + Constantes.SALIDA_VOLUNTARIA);
		} else if (coordY == 0 && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde norte del bosque, con el linde del mismo a tu espalda");
		} else if (coordY == 0 && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde norte del bosque, con el linde del mismo a tu izquierda");
		} else if (coordY == 0 && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde norte del bosque, con el linde del mismo a tu derecha");
			/* ?, MAX. */
		} else if (coordY >= alto && Constantes.MIRAR_NORTE.equals(encarado)) {
			log("Te encuentras en el borde sur del bosque, con el linde del mismo a tu espalda");
		} else if (coordY >= alto && Constantes.MIRAR_SUR.equals(encarado)) {
			log("Te encuentras en el borde sur del bosque, con el linde del mismo frente a ti");
		} else if (coordY >= alto && Constantes.MIRAR_ESTE.equals(encarado)) {
			log("Te encuentras en el borde sur del bosque, con el linde del mismo a tu derecha");
		} else if (coordY >= alto && Constantes.MIRAR_OESTE.equals(encarado)) {
			log("Te encuentras en el borde sur del bosque, con el linde del mismo a tu izquierda");
			/* ?.?. */
		} else {
			log("Te encuentras en el borde del bosque, pero no sabes exactamente dónde");
		}

		tablero.getAlto();
		tablero.getAncho();

	}

	static void printTurno(int turnoAparente) {
		log("Turno [" + turnoAparente + "]");
		log("------------------------------");
	}

}
