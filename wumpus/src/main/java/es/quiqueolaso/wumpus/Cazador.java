package es.quiqueolaso.wumpus;

public class Cazador extends Item {

	private boolean alive;

	private int numeroFlechas;

	private String encarado;

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

	public String getEncarado() {
		return encarado;
	}

	public void setEncarado(String encarado) {
		this.encarado = encarado;
	}

	public Cazador(int coordX, int coordY, int numeroFlechas) {
		super(coordX, coordY);
		this.numeroFlechas = numeroFlechas;
		this.alive = true;
	}

	public String accion(String operacion) {
		String respuesta;
		if (Constantes.AVANZAR.equals(operacion)) {
			respuesta = "has avanzado en direccion X";
		} else if (Constantes.GIRAR_NORTE.equals(operacion)) {
			encarado = Constantes.GIRAR_NORTE;
			respuesta = "te has encarado al norte";
		} else if (Constantes.GIRAR_SUR.equals(operacion)) {
			encarado = Constantes.GIRAR_SUR;
			respuesta = "te has encarado al sur";
		} else if (Constantes.GIRAR_ESTE.equals(operacion)) {
			encarado = Constantes.GIRAR_ESTE;
			respuesta = "te has encarado al este";
		} else if (Constantes.GIRAR_OESTE.equals(operacion)) {
			encarado = Constantes.GIRAR_OESTE;
			respuesta = "te has encarado al oeste";
		} else if (Constantes.SUICIDIO.equals(operacion)) {
			this.setAlive(false);
			respuesta = "te has suicidado";
		} else if (Constantes.DISPARAR.equals(operacion)) {
			if (numeroFlechas > 0) {
				this.numeroFlechas--;
				respuesta = "has disparado 1 flecha. Te quedan " + numeroFlechas;
			} else if (numeroFlechas == 2) {
				this.numeroFlechas--;
				respuesta = "has disparado 1 flecha. Te queda 1 flecha. Sé cuidadoso";
			} else {
				respuesta = "no te quedan flechas para disparar";
			}
		} else if (Constantes.SALIR.equals(operacion)) {
			respuesta = "has salido del bosque";
		} else {
			respuesta = "";
		}
		return respuesta;
	}

}
