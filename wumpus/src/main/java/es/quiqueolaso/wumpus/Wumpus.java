package es.quiqueolaso.wumpus;

public class Wumpus extends Item {

	private boolean alive;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Wumpus(int coordX, int coordY) {
		super(coordX, coordY);
		this.alive = true;

	}

}
