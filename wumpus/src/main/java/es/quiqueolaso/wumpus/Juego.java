package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	Tablero tablero;

	public Juego(int height, int width, int numeroTrampas, int numeroFlechas) {

		tablero = new Tablero(height, width);

		tablero.setTrampas(numeroTrampas, height, width);

		Cazador cazador = new Cazador(0, 0, numeroFlechas);
		tablero.setCazador(cazador);

		Wumpus monstruo = new Wumpus(0, 0);
		tablero.setWumpus(monstruo);

		Oro oro = new Oro(0, 0);
		tablero.setOro(oro);

		tablero.inicializar();

	}

	public void run() {
		List<Turno> jugadas = new ArrayList<Turno>();
		int turno = 0;

		Turno disposicionInicial = new Turno(turno, tablero);
		jugadas.add(disposicionInicial);

		String operacion = JuegoHelper.printDialogoInicial();
		String respuesta = null;

		if (JuegoHelper.isOperacionSistema(operacion)) {
			if (Constantes.SALIR_PARTIDA.equals(operacion)) {
				System.exit(0);
			} else if (Constantes.RESET_PARTIDA.equals(operacion)) {
				/* TODO */
			}
		} else {
			respuesta = tablero.getCazador().accion(operacion);
			System.out.println(respuesta);
		}

		while (tablero.getCazador().isAlive()) {
			turno++;
			System.out.println("Turno [" + turno + "]");
			Turno newTurno = new Turno(turno, tablero);
			jugadas.add(newTurno);
			operacion = JuegoHelper.printDialogoTurno();
			respuesta = tablero.getCazador().accion(operacion);
			if (Constantes.DEBUG) {
				System.out.println(tablero.toString());
				System.out.println(
						"Cazador:" + tablero.getCazador().getCoordX() + "," + tablero.getCazador().getCoordY());
				System.out.println("Wumpus:" + tablero.getWumpus().getCoordX() + "," + tablero.getWumpus().getCoordY());
				System.out.println("Oro:" + tablero.getOro().getCoordX() + "," + tablero.getOro().getCoordY());
			}
		}
	}

}
