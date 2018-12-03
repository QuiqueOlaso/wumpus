/*
 * 
 */
package es.quiqueolaso.wumpus;

// TODO: Auto-generated Javadoc
/**
 * The Class Turno.
 */
public class Turno {

	/** The id. */
	private int id;

	/** The tablero. */
	private Tablero tablero;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * Sets the tablero.
	 *
	 * @param tablero the new tablero
	 */
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	/**
	 * Instantiates a new turno.
	 *
	 * @param id the id
	 * @param tablero the tablero
	 */
	public Turno(int id, Tablero tablero) {
		this.id = id;
		this.tablero = tablero;
	}

}
