package es.quiqueolaso.wumpus;

import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		String operacion = scanner.nextLine();
		scanner.close();
		return operacion;
	}

	static String printDialogoTurno() {
		printControles();
		Scanner scanner = new Scanner(System.in);
		String operacion = scanner.nextLine();
		scanner.close();
		return operacion;
	}

}