package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

import es.quiqueolaso.wumpus.utils.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroTestAux.
 */
public class TableroTestAux3 {

	/**
	 * Test check distancia trampas 01.
	 */
	static void testCheckDistanciaTrampas01() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Cazador cazador = new Cazador(0, 0, 0);
		myTablero.setCazador(cazador);
		List<Trampa> trampas = new ArrayList<Trampa>();
		trampas.add(new Trampa(1, 0, 0));
		myTablero.setTrampas(trampas);
		executeTest("1", myTablero);
	}

	/**
	 * Test check distancia trampas 02.
	 */
	static void testCheckDistanciaTrampas02() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Cazador cazador = new Cazador(4, 4, 0);
		myTablero.setCazador(cazador);
		List<Trampa> trampas = new ArrayList<Trampa>();
		trampas.add(new Trampa(1, 0, 0));
		trampas.add(new Trampa(2, 5, 5));
		myTablero.setTrampas(trampas);
		executeTest("2", myTablero);
	}

	/**
	 * Test check distancia trampas 03.
	 */
	static void testCheckDistanciaTrampas03() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Cazador cazador = new Cazador(5, 5, 0);
		myTablero.setCazador(cazador);
		List<Trampa> trampas = new ArrayList<Trampa>();
		trampas.add(new Trampa(1, 5, 5));
		trampas.add(new Trampa(2, 9, 9));
		myTablero.setTrampas(trampas);
		executeTest("3", myTablero);
	}

	/**
	 * Test check distancia trampas 04.
	 */
	static void testCheckDistanciaTrampas04() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Cazador cazador = new Cazador(9, 9, 0);
		myTablero.setCazador(cazador);
		List<Trampa> trampas = new ArrayList<Trampa>();
		trampas.add(new Trampa(1, 5, 5));
		trampas.add(new Trampa(2, 9, 9));
		myTablero.setTrampas(trampas);		
		executeTest("4", myTablero);
	}

	/**
	 * Test check distancia trampas 05.
	 */
	static void testCheckDistanciaTrampas05() {
		int alto = 9;
		int ancho = 9;
		Tablero myTablero = new Tablero(alto, ancho);
		Cazador cazador = new Cazador(3, 2, 0);
		myTablero.setCazador(cazador);
		List<Trampa> trampas = new ArrayList<Trampa>();
		trampas.add(new Trampa(1, 0, 0));
		trampas.add(new Trampa(1, 9, 9));
		myTablero.setTrampas(trampas);
		executeTest("5", myTablero);
	}

	/**
	 * Execute test.
	 *
	 * @param test      the test
	 * @param myTablero the my tablero
	 */
	private static void executeTest(String test, Tablero myTablero) {
		int respuesta = myTablero.checkDistanciaTrampas();
		Log.debug("Test " + test + ". ¿Estan a una distancia aceptable? " + respuesta);
	}

}
