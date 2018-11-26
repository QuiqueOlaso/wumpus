package es.quiqueolaso.wumpus;

public class Cazador extends Item {

	private boolean alive;

	private int numeroFlechas;

	public int getNumeroFlechas() {
		return numeroFlechas;
	}

	public void setNumeroFlechas(int numeroFlechas) {
		this.numeroFlechas = numeroFlechas;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Cazador(int coordX, int coordY, int numeroFlechas) {
		super(coordX, coordY);
		this.numeroFlechas = numeroFlechas;
		this.alive = true;
	}

}
