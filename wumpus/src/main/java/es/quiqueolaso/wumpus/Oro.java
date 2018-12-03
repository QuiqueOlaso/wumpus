package es.quiqueolaso.wumpus;

// TODO: Auto-generated Javadoc
/**
 * The Class Oro.
 */
public class Oro extends Item {

	/** The found. */
	private boolean found;

	/**
	 * Checks if is found.
	 *
	 * @return true, if is found
	 */
	public boolean isFound() {
		return found;
	}

	/**
	 * Sets the found.
	 *
	 * @param found the new found
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

	/**
	 * Instantiates a new oro.
	 *
	 * @param coordX the coord X
	 * @param coordY the coord Y
	 */
	public Oro(int coordX, int coordY) {
		super(coordX, coordY);
		this.setFound(false);
	}

}
