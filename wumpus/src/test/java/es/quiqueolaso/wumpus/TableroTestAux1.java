package es.quiqueolaso.wumpus;

import es.quiqueolaso.wumpus.utils.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroTestAux.
 */
public class TableroTestAux1 {

	/**
	 * Test check distancia inicial wumpus 01.
	 */
	static void testCheckDistanciaInicialWumpus01() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Wumpus wumpus = new Wumpus(0, 0);
		myTablero.setWumpus(wumpus);
		Cazador cazador = new Cazador(0, 0, 0);
		myTablero.setCazador(cazador);
		executeTest("1", myTablero);
	}

	/**
	 * Test check distancia inicial wumpus 02.
	 */
	static void testCheckDistanciaInicialWumpus02() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Wumpus wumpus = new Wumpus(0, 0);
		myTablero.setWumpus(wumpus);
		Cazador cazador = new Cazador(4, 4, 0);
		myTablero.setCazador(cazador);
		executeTest("2", myTablero);
	}

	/**
	 * Test check distancia inicial wumpus 03.
	 */
	static void testCheckDistanciaInicialWumpus03() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Wumpus wumpus = new Wumpus(0, 0);
		myTablero.setWumpus(wumpus);
		Cazador cazador = new Cazador(5, 5, 0);
		myTablero.setCazador(cazador);
		executeTest("3", myTablero);
	}

	/**
	 * Test check distancia inicial wumpus 04.
	 */
	static void testCheckDistanciaInicialWumpus04() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Wumpus wumpus = new Wumpus(0, 0);
		myTablero.setWumpus(wumpus);
		Cazador cazador = new Cazador(9, 9, 0);
		myTablero.setCazador(cazador);
		executeTest("4", myTablero);
	}

	/**
	 * Test check distancia inicial wumpus 05.
	 */
	static void testCheckDistanciaInicialWumpus05() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Wumpus wumpus = new Wumpus(2, 3);
		myTablero.setWumpus(wumpus);
		Cazador cazador = new Cazador(3, 2, 0);
		myTablero.setCazador(cazador);
		executeTest("5", myTablero);
	}

	/**
	 * Execute test.
	 *
	 * @param test      the test
	 * @param myTablero the my tablero
	 */
	private static void executeTest(String test, Tablero myTablero) {
		boolean respuesta = myTablero.checkDistanciaInicialWumpus();
		Log.debug("Test " + test + ". ¿Estan a una distancia aceptable? " + respuesta);
	}

}
