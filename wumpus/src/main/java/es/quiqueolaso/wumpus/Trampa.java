package es.quiqueolaso.wumpus;

public class Trampa extends Item {

	private int id;

	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Trampa(int id, int coordX, int coordY) {
		super(coordX, coordY);
		this.setId(id);
		this.setEnabled(true);
	}

}
