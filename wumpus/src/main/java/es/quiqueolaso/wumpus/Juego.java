package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Juego.
 */
public class Juego {

	/** The tablero. */
	Tablero tablero;

	/**
	 * Instantiates a new juego.
	 *
	 * @param height        the height
	 * @param width         the width
	 * @param numeroTrampas the numero trampas
	 * @param numeroFlechas the numero flechas
	 */
	public Juego(int height, int width, int numeroTrampas, int numeroFlechas) {

		tablero = new Tablero(height, width);

		/* elementos principales de tablero. */
		Cazador cazador = new Cazador(0, 0, numeroFlechas);
		tablero.setCazador(cazador);

		Wumpus monstruo = new Wumpus(0, 0);
		tablero.setWumpus(monstruo);

		Oro oro = new Oro(0, 0);
		tablero.setOro(oro);

		/* disposicion de tablero. */

		tablero.inicializar();

		tablero.inicializarTrampas(numeroTrampas, height, width);

	}

	/**
	 * Run.
	 */
	public void run() {
		List<Turno> jugadas = new ArrayList<Turno>();
		int turno = 0;
		int turnoAparente = turno + 1;
		JuegoHelper.printTurno(turnoAparente);
		JuegoHelper.printDialogoInicial();
		String operacion = null;
		String respuesta = null;

		while (tablero.getCazador().isAlive()) {
			Turno newTurno = new Turno(turno, tablero);
			jugadas.add(newTurno);
			JuegoHelper.printPosicionCazadorRespectoTablero(tablero);
			printInfoAboutTurno();
			operacion = JuegoHelper.printDialogoTurno();
			if (JuegoHelper.isOperacionSistema(operacion)) {
				if (Constantes.ACCION_SALIR_PARTIDA.equalsIgnoreCase(operacion)) {
					System.exit(0);
				} else if (Constantes.ACCION_RESET_PARTIDA.equalsIgnoreCase(operacion)) {
					/* TODO */
				}
			} else {
				respuesta = tablero.getCazador().accion(operacion);
				JuegoHelper.log(respuesta);
				turno++;
				turnoAparente++;
				JuegoHelper.printTurno(turnoAparente);
			}
		}
	}

	private void printInfoAboutTurno() {
		if (Constantes.DEBUG) {
			JuegoHelper.log(tablero.toString());
			JuegoHelper.log("Cazador:" + tablero.getCazador().getCoordX() + "," + tablero.getCazador().getCoordY());
			JuegoHelper.log("Wumpus: " + tablero.getWumpus().getCoordX() + "," + tablero.getWumpus().getCoordY());
			JuegoHelper.log("Oro: " + tablero.getOro().getCoordX() + "," + tablero.getOro().getCoordY());
			if (tablero.getTrampas() == null || tablero.getTrampas().isEmpty()) {
				JuegoHelper.log("Trampas: no existen");
			} else {
				for (Trampa trampa : tablero.getTrampas()) {
					JuegoHelper.log("Trampa: " + trampa.getCoordX() + "," + trampa.getCoordY());
				}
			}
		}
	}

}
