/**
 * 
 */
package es.quiqueolaso.wumpus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TableroTest.
 *
 * @author RyQ
 */
public class TableroTest {

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/* nothing to do. */
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		/* nothing to do. */
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		/* nothing to do. */
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		/* nothing to do. */
	}

	/**
	 * Test method for
	 * {@link es.quiqueolaso.wumpus.Tablero#checkDistanciaInicialWumpus()}.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCheckDistanciaInicialWumpus() throws Exception {
		TableroTestAux1.testCheckDistanciaInicialWumpus01();
		TableroTestAux1.testCheckDistanciaInicialWumpus02();
		TableroTestAux1.testCheckDistanciaInicialWumpus03();
		TableroTestAux1.testCheckDistanciaInicialWumpus04();
		TableroTestAux1.testCheckDistanciaInicialWumpus05();
	}

	/**
	 * Test method for
	 * {@link es.quiqueolaso.wumpus.Tablero#checkDistanciaInicialOro()}.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCheckDistanciaInicialOro() throws Exception {
		TableroTestAux2.testCheckDistanciaInicialOro01();
		TableroTestAux2.testCheckDistanciaInicialOro02();
		TableroTestAux2.testCheckDistanciaInicialOro03();
		TableroTestAux2.testCheckDistanciaInicialOro04();
		TableroTestAux2.testCheckDistanciaInicialOro05();
	}

	/**
	 * Test method for
	 * {@link es.quiqueolaso.wumpus.Tablero#checkDistanciaTrampas()}.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCheckDistanciaTrampas() throws Exception {
		TableroTestAux3.testCheckDistanciaTrampas01();
		TableroTestAux3.testCheckDistanciaTrampas02();
		TableroTestAux3.testCheckDistanciaTrampas03();
		TableroTestAux3.testCheckDistanciaTrampas04();
		TableroTestAux3.testCheckDistanciaTrampas05();
	}

}
