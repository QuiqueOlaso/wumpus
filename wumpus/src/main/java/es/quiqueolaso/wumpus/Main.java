package es.quiqueolaso.wumpus;

import java.util.ArrayList;
import java.util.List;

import es.quiqueolaso.wumpus.utils.Option;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		List<String> argsList = new ArrayList<String>();
		List<Option> optsList = new ArrayList<Option>();
		List<String> doubleOptsList = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {
			switch (args[i].charAt(0)) {
			case '-':
				if (args[i].length() < 2)
					throw new IllegalArgumentException("Not a valid argument: " + args[i]);
				if (args[i].charAt(1) == '-') {
					if (args[i].length() < 3)
						throw new IllegalArgumentException("Not a valid argument: " + args[i]);
					// --opt
					doubleOptsList.add(args[i].substring(2, args[i].length()));
				} else {
					if (args.length - 1 == i)
						throw new IllegalArgumentException("Expected arg after: " + args[i]);
					// -opt
					optsList.add(new Option(args[i], args[i + 1]));
					i++;
				}
				break;
			default:
				// arg
				argsList.add(args[i]);
				break;
			}
		}

		run();
	}

	/**
	 * Run.
	 */
	private static void run() {
		int alturaPorDefecto = 10;
		int anchuraPorDefecto = 10;
		int numeroFlechasPorDefecto = 1;
		int numeroTrampasPorDefecto = 1;
		Juego juego = new Juego(alturaPorDefecto, anchuraPorDefecto, numeroFlechasPorDefecto, numeroTrampasPorDefecto);
		juego.run();
	}

}
