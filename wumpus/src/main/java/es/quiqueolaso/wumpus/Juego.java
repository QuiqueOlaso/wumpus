package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	public Juego(int height, int width, int numeroTrampas, int numeroFlechas) {

		Tablero tablero = new Tablero(height, width);

		tablero.setTrampas(numeroTrampas, height, width);

		Cazador jugador = new Cazador(0, 0, numeroFlechas);
		tablero.setCazador(jugador);

		Wumpus monstruo = new Wumpus(0, 0);
		tablero.setWumpus(monstruo);

		Oro oro = new Oro(0, 0);
		tablero.setOro(oro);

		List<Turno> jugadas = new ArrayList<Turno>();
		int turno = 0;

		Turno disposicionInicial = new Turno(turno, tablero);
		jugadas.add(disposicionInicial);

		printDialogoInicial();

		while (jugador.isAlive()) {
			turno++;
			Turno newTurno = new Turno(turno, tablero);
			jugadas.add(newTurno);
			printDialogoTurno();
		}

	}

	private void printDialogoTurno() {
		// TODO Auto-generated method stub

	}

	private void printDialogoInicial() {
		// TODO Auto-generated method stub

	}

}
