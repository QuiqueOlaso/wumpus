/*
 * 
 */
package es.quiqueolaso.wumpus;

// TODO: Auto-generated Javadoc
/**
 * The Class Wumpus.
 */
public class Wumpus extends Item {

	/** The alive. */
	private boolean alive;

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Sets the alive.
	 *
	 * @param alive the new alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Instantiates a new wumpus.
	 *
	 * @param coordX the coord X
	 * @param coordY the coord Y
	 */
	public Wumpus(int coordX, int coordY) {
		super(coordX, coordY);
		this.alive = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder();
		sbr.append("Trampa[");
		sbr.append("x=");
		sbr.append(this.getCoordX());
		sbr.append(",y=");
		sbr.append(this.getCoordY());
		sbr.append(",alive=");
		sbr.append(this.isAlive());
		sbr.append("]");
		return sbr.toString();
	}

}
