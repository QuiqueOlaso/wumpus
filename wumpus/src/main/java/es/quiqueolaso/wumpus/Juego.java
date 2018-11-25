package es.quiqueolaso.wumpus;

public class Juego {

	public Juego(int height, int width, int numeroTrampas, int numeroFlechas) {

		Tablero tablero = new Tablero(height, width);

		tablero.setTrampas(numeroTrampas, height, width);

		Cazador jugador = new Cazador(numeroFlechas);
		tablero.setCazador(jugador);

		Wumpus monstruo = new Wumpus();
		tablero.setWunWumpus();

	}

}
