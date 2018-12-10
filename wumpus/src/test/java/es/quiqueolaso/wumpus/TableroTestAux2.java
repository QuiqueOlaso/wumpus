package es.quiqueolaso.wumpus;

import es.quiqueolaso.wumpus.utils.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroTestAux.
 */
public class TableroTestAux2 {

	/**
	 * Test check distancia inicial Oro 01.
	 */
	static void testCheckDistanciaInicialOro01() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Oro oro = new Oro(0, 0);
		myTablero.setOro(oro);
		Cazador cazador = new Cazador(0, 0, 0);
		myTablero.setCazador(cazador);
		executeTest("1", myTablero);
	}

	/**
	 * Test check distancia inicial Oro 02.
	 */
	static void testCheckDistanciaInicialOro02() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Oro oro = new Oro(0, 0);
		myTablero.setOro(oro);
		Cazador cazador = new Cazador(4, 4, 0);
		myTablero.setCazador(cazador);
		executeTest("2", myTablero);
	}

	/**
	 * Test check distancia inicial Oro 03.
	 */
	static void testCheckDistanciaInicialOro03() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Oro oro = new Oro(0, 0);
		myTablero.setOro(oro);
		Cazador cazador = new Cazador(5, 5, 0);
		myTablero.setCazador(cazador);
		executeTest("3", myTablero);
	}

	/**
	 * Test check distancia inicial Oro 04.
	 */
	static void testCheckDistanciaInicialOro04() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Oro oro = new Oro(0, 0);
		myTablero.setOro(oro);
		Cazador cazador = new Cazador(9, 9, 0);
		myTablero.setCazador(cazador);
		executeTest("4", myTablero);
	}

	/**
	 * Test check distancia inicial Oro 05.
	 */
	static void testCheckDistanciaInicialOro05() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Oro oro = new Oro(2, 3);
		myTablero.setOro(oro);
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
		boolean respuesta = myTablero.checkDistanciaInicialOro();
		Log.debug("Test " + test + ". ¿Estan a una distancia aceptable? " + respuesta);
	}

}
