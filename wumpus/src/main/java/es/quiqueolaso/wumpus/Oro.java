package es.quiqueolaso.wumpus;

public class Oro extends Item {

	private boolean found;

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public Oro(int coordX, int coordY) {
		super(coordX, coordY);
		this.setFound(false);
	}

}
