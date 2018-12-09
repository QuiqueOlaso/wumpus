package es.quiqueolaso.wumpus;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/* nothing to do. */
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		/* nothing to do. */
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/* nothing to do. */
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		/* nothing to do. */
	}

	@Test
	public boolean testCheckLejaniaWumpus() {
		Tablero tablero = new Tablero(9, 9);
		Cazador cazador = new Cazador(3, 4, 0);
		tablero.setCazador(cazador);
		Wumpus monstruo = new Wumpus(3, 4);
		tablero.setWumpus(monstruo);
		tablero.checkLejaniaWumpus();
	}

}
