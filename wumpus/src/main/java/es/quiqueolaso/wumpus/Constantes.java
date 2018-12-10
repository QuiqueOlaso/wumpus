package es.quiqueolaso.wumpus;

import es.quiqueolaso.wumpus.utils.LogLevel;

// TODO: Auto-generated Javadoc
/**
 * The Class Constantes.
 */
public final class Constantes {

	/* DEBUG */

	/** The Constant LOGLEVEL. */
	public static final String LOGLEVEL = LogLevel.DEBUG;

	/* OPERACIONES DE SISTEMA. */

	/** The Constant ACCION_SALIR_PARTIDA. */
	public static final String ACCION_SALIR_PARTIDA = "Q";

	/** The Constant ACCION_RESET_PARTIDA. */
	public static final String ACCION_RESET_PARTIDA = "R";

	/* ACCIONES PERMITIDAS A CAZADOR. */

	/** The Constant ACCION_MIRAR_NORTE. */
	public static final String ACCION_MIRAR_NORTE = "N";

	/** The Constant ACCION_MIRAR_SUR. */
	public static final String ACCION_MIRAR_SUR = "S";

	/** The Constant ACCION_MIRAR_ESTE. */
	public static final String ACCION_MIRAR_ESTE = "E";

	/** The Constant ACCION_MIRAR_OESTE. */
	public static final String ACCION_MIRAR_OESTE = "W";

	/** The Constant ACCION_AVANZAR. */
	public static final String ACCION_AVANZAR = "A";

	/** The Constant ACCION_DISPARAR. */
	public static final String ACCION_DISPARAR = "F";

	/** The Constant ACCION_SALIR. */
	public static final String ACCION_SALIR = "M";

	/** The Constant ACCION_SUICIDIO. */
	public static final String ACCION_SUICIDIO = "X";

	/** The Constant ACCION_SALIDA_VOLUNTARIA. */
	public static final String ACCION_SALIDA_VOLUNTARIA = "G";

	/* LEYENDA. */

	/** The Constant LEYENDA_TRAMPA. */
	static final String LEYENDA_TRAMPA = "\u002A";

	/** The Constant LEYENDA_CASILLA. */
	static final String LEYENDA_CASILLA = "\u00B7";

	/** The Constant LEYENDA_ORO. */
	static final String LEYENDA_ORO = "\u0047";

	/** The Constant LEYENDA_WUMPUS. */
	static final String LEYENDA_WUMPUS = "\u0057";

	/** The Constant LEYENDA_CAZADOR_OESTE. */
	static final String LEYENDA_CAZADOR_OESTE = "\u02C2";

	/** The Constant LEYENDA_CAZADOR_ESTE. */
	static final String LEYENDA_CAZADOR_ESTE = "\u02C3";

	/** The Constant LEYENDA_CAZADOR_SUR. */
	static final String LEYENDA_CAZADOR_SUR = "\u02C5";

	/** The Constant LEYENDA_CAZADOR_NORTE. */
	static final String LEYENDA_CAZADOR_NORTE = "\u02C4";

	/** The Constant LEYENDA_CAZADOR_DESCONOCIDO. */
	static final String LEYENDA_CAZADOR_DESCONOCIDO = "-";

}
