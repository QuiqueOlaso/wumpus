package es.quiqueolaso.wumpus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JuegoHelper {

	protected static boolean isOperacionSistema(String operacion) {
		if (Constantes.RESET_PARTIDA.equals(operacion) || Constantes.SALIR_PARTIDA.equals(operacion)) {
			return true;
		} else {
			return false;
		}
	}

	static void printControles() {
		System.out.println(" --------------------------");
		System.out.println("Controles:");
		System.out.println(" * 'N' encarar al norte");
		System.out.println(" * 'S' encarar al sur");
		System.out.println(" * 'W' encarar al oeste");
		System.out.println(" * 'E' encarar al este");
		System.out.println(" * 'A' avanzar");
		System.out.println(" * 'F' disparar");
		System.out.println(" * 'M' salir del bosque");
		System.out.println(" --------------------------");
		System.out.println(" * 'Q' abandonar el juego");
		System.out.println(" * 'R' reiniciar el juego");
	}

	static String printDialogoInicial() {
		System.out.println("Eres el cazador.");
		System.out.println("Te encuentras en un bosque");
		System.out.println("Puedes avanzar en todas direcciones, pero ¡cuidado! hay trampas");
		System.out.println("... y el Wumpus está al acecho");
		printControles();
		return leerRespuesta();
	}

	static String printDialogoTurno() {
		printControles();
		return leerRespuesta();
	}

	private static String leerRespuesta() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String operacion = null;
		try {
			operacion = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return operacion;
	}

}
