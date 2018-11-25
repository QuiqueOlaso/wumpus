package es.quiqueolaso.wumpus;

public class Item {

	private int coordX;

	private int coordY;

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public Item(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

}
