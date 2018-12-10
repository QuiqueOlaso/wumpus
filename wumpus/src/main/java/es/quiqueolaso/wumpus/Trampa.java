/*
 * 
 */
package es.quiqueolaso.wumpus;

// TODO: Auto-generated Javadoc
/**
 * The Class Trampa.
 */
public class Trampa extends Item {

	/** The id. */
	private int id;

	/** The enabled. */
	private boolean enabled;

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
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Instantiates a new trampa.
	 *
	 * @param id     the id
	 * @param coordX the coord X
	 * @param coordY the coord Y
	 */
	public Trampa(int id, int coordX, int coordY) {
		super(coordX, coordY);
		this.setId(id);
		this.setEnabled(true);
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
		sbr.append("id=");
		sbr.append(this.getId());
		sbr.append(",x=");
		sbr.append(this.getCoordX());
		sbr.append(",y=");
		sbr.append(this.getCoordY());
		sbr.append("]");
		return sbr.toString();
	}

}
