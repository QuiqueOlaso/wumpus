package es.quiqueolaso.wumpus;

public class Turno {

	private int id;

	private Tablero tablero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Turno(int id, Tablero tablero) {
		this.id = id;
		this.tablero = tablero;
	}

}
