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

	/**
	 * Encarar inicial.
	 *
	 * @return the string
	 */
	private String encararInicial() {
		Random randomizer = new Random();
		List<String> list = new ArrayList<String>();
		list.add(Constantes.ACCION_MIRAR_NORTE);
		list.add(Constantes.ACCION_MIRAR_SUR);
		list.add(Constantes.ACCION_MIRAR_ESTE);
		list.add(Constantes.ACCION_MIRAR_OESTE);
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
		if (Constantes.ACCION_AVANZAR.equalsIgnoreCase(operacion)) {
			if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(encarado)) {
				this.setCoordY(this.getCoordY() - 1);
				respuesta = "has avanzado en direccion Norte";
			} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(encarado)) {
				this.setCoordY(this.getCoordY() + 1);
				respuesta = "has avanzado en direccion Sur";
			} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(encarado)) {
				this.setCoordX(this.getCoordX() + 1);
				respuesta = "has avanzado en direccion Este";
			} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(encarado)) {
				this.setCoordX(this.getCoordX() - 1);
				respuesta = "has avanzado en direccion Oeste";
			} else {
				/* . */
			}
		} else if (Constantes.ACCION_MIRAR_NORTE.equalsIgnoreCase(operacion)) {
			encarado = Constantes.ACCION_MIRAR_NORTE;
			respuesta = "te has encarado al norte";
		} else if (Constantes.ACCION_MIRAR_SUR.equalsIgnoreCase(operacion)) {
			encarado = Constantes.ACCION_MIRAR_SUR;
			respuesta = "te has encarado al sur";
		} else if (Constantes.ACCION_MIRAR_ESTE.equalsIgnoreCase(operacion)) {
			encarado = Constantes.ACCION_MIRAR_ESTE;
			respuesta = "te has encarado al este";
		} else if (Constantes.ACCION_MIRAR_OESTE.equalsIgnoreCase(operacion)) {
			encarado = Constantes.ACCION_MIRAR_OESTE;
			respuesta = "te has encarado al oeste";
		} else if (Constantes.ACCION_SUICIDIO.equalsIgnoreCase(operacion)) {
			this.setAlive(false);
			respuesta = "te has suicidado";
		} else if (Constantes.ACCION_DISPARAR.equalsIgnoreCase(operacion)) {
			if (numeroFlechas > 0) {
				this.numeroFlechas--;
				respuesta = "has disparado 1 flecha. Te quedan " + numeroFlechas;
			} else if (numeroFlechas == 2) {
				this.numeroFlechas--;
				respuesta = "has disparado 1 flecha. Te queda 1 flecha. S\u00e9 cuidadoso";
			} else {
				respuesta = "no te quedan flechas para disparar";
			}
		} else if (Constantes.ACCION_SALIR.equalsIgnoreCase(operacion)) {
			respuesta = "has salido del bosque";
		} else {
			respuesta = "";
		}
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder();
		sbr.append("Cazador[");
		sbr.append("x=");
		sbr.append(this.getCoordX());
		sbr.append(",y=");
		sbr.append(this.getCoordY());
		sbr.append(",encarado=");
		sbr.append(this.getEncarado());
		sbr.append(",num.flechas=");
		sbr.append(this.getNumeroFlechas());
		sbr.append(",alive=");
		sbr.append(this.isAlive());
		sbr.append("]");
		return sbr.toString();
	}

}
