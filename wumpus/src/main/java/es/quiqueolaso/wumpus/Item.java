package es.quiqueolaso.wumpus;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public class Item {

	/** The coord X. */
	private int coordX;

	/** The coord Y. */
	private int coordY;

	/**
	 * Gets the coord X.
	 *
	 * @return the coord X
	 */
	public int getCoordX() {
		return coordX;
	}

	/**
	 * Sets the coord X.
	 *
	 * @param coordX the new coord X
	 */
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	/**
	 * Gets the coord Y.
	 *
	 * @return the coord Y
	 */
	public int getCoordY() {
		return coordY;
	}

	/**
	 * Sets the coord Y.
	 *
	 * @param coordY the new coord Y
	 */
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	/**
	 * Instantiates a new item.
	 *
	 * @param coordX the coord X
	 * @param coordY the coord Y
	 */
	public Item(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

}
