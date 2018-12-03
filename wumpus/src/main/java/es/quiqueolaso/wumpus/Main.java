package es.quiqueolaso.wumpus;

public class Main {

	public static void main(String[] args) {
		int alturaPorDefecto = 10;
		int anchuraPorDefecto = 10;
		int numeroFlechasPorDefecto = 1;
		int numeroTrampasPorDefecto = 1;
		Juego juego = new Juego(alturaPorDefecto, anchuraPorDefecto, numeroFlechasPorDefecto, numeroTrampasPorDefecto);
		juego.run();
	}

}
