package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Cazador.
 */
public class Cazador extends Item {

	/** The alive. */
	private boolean alive;

	/** The numero flechas. */
	private int numeroFlechas;

	/** The encarado. */
	private String encarado;

	/**
	 * Gets the numero flechas.
	 *
	 * @return the numero flechas
	 */
	public int getNumeroFlechas() {
		return numeroFlechas;
	}

	/**
	 * Sets the numero flechas.
	 *
	 * @param numeroFlechas the new numero flechas
	 */
	public void setNumeroFlechas(int numeroFlechas) {
		this.numeroFlechas = numeroFlechas;
	}

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
	 * Gets the encarado.
	 *
	 * @return the encarado
	 */
	public String getEncarado() {
		return encarado;
	}

	/**
	 * Sets the encarado.
	 *
	 * @param encarado the new encarado
	 */
	public void setEncarado(String encarado) {
		this.encarado = encarado;
	}

	/**
	 * Instantiates a new cazador.
	 *
	 * @param coordX        the coord X
	 * @param coordY        the coord Y
	 * @param numeroFlechas the numero flechas
	 */
	public Cazador(int coordX, int coordY, int numeroFlechas) {
		super(coordX, coordY);
		this.numeroFlechas = numeroFlechas;
		this.alive = true;
		this.encarado = encararInicial();
	}

	private String encararInicial() {
		Random randomizer = new Random();
		List<String> list = new ArrayList<String>();
		list.add(Constantes.MIRAR_NORTE);
		list.add(Constantes.MIRAR_SUR);
		list.add(Constantes.MIRAR_ESTE);
		list.add(Constantes.MIRAR_OESTE);
		String random = list.get(randomizer.nextInt(list.size()));
		return random;
	}

	/**
	 * Accion.
	 *
	 * @param operacion the operacion
	 * @return the string
	 */
	public String accion(String operacion) {
		String respuesta = null;
		if (Constantes.AVANZAR.equals(operacion)) {
			if (Constantes.MIRAR_NORTE.equals(encarado)) {
				this.setCoordY(this.getCoordY() - 1);
				respuesta = "has avanzado en direccion Norte";
			} else if (Constantes.MIRAR_SUR.equals(encarado)) {
				this.setCoordY(this.getCoordY() + 1);
				respuesta = "has avanzado en direccion Sur";
			} else if (Constantes.MIRAR_ESTE.equals(encarado)) {
				this.setCoordX(this.getCoordX() + 1);
				respuesta = "has avanzado en direccion Este";
			} else if (Constantes.MIRAR_OESTE.equals(encarado)) {
				this.setCoordX(this.getCoordX() - 1);
				respuesta = "has avanzado en direccion Oeste";
			} else {
				/* . */
			}

		} else if (Constantes.MIRAR_NORTE.equals(operacion)) {
			encarado = Constantes.MIRAR_NORTE;
			respuesta = "te has encarado al norte";
		} else if (Constantes.MIRAR_SUR.equals(operacion)) {
			encarado = Constantes.MIRAR_SUR;
			respuesta = "te has encarado al sur";
		} else if (Constantes.MIRAR_ESTE.equals(operacion)) {
			encarado = Constantes.MIRAR_ESTE;
			respuesta = "te has encarado al este";
		} else if (Constantes.MIRAR_OESTE.equals(operacion)) {
			encarado = Constantes.MIRAR_OESTE;
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
