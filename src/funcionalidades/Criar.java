package funcionalidades;

import java.util.LinkedList;

import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;

public class Criar {

	// Aquí se inserta los movimientos de los dos padres
	private static LinkedList<Move> movimientosPadres = new LinkedList<Move>();

	private static LinkedList<Move> movimientosHijo = new LinkedList<Move>();

//	private static Pokemon pokemonHijo = new Pokemon(0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null);

	public static Pokemon Criar(Pokemon pokemon1, Pokemon pokemon2, Trainer entrenador) {

		Pokemon pokemonHijo = new Pokemon(0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null);

		// nombre del pokemon hijo
		pokemonHijo.setName(elegirAleatoriamenteNombrePokemonHijo(pokemon1, pokemon2));

		insertarMovimientosEnHijo(pokemon1.getMoves(), pokemon2.getMoves());
		
		pokemonHijo.setMoves(movimientosHijo);

		entrenador.getTodosLosPokemon().add(pokemonHijo);

		Captura.insertarEnBbDdElPokemonEncontrado(pokemonHijo, "NoProgramado", entrenador.getId());
		return pokemonHijo;

	}

// añade los movimietos del padre1 a la LinkedList<Move>movimientosPadres
	private static void insertraMovimietosPadre1(LinkedList<Move> movimientosPadre1) {

		for (int i = 0; i < movimientosPadre1.size(); i++) {

			Move movimietoDelPadre = movimientosPadre1.get(i);
			movimientosPadres.add(movimietoDelPadre);
			
			System.out.println("movimientos del padre1: "+movimientosPadres.toString());
		}

	}

	// inserta en el hijo movimietos hasta un máximo de 4 a partir de la linkedlist
	// creada con los movimientos de los dos padres
	private static void insertarMovimientosEnHijo(LinkedList<Move> movimientosPadre1,
			LinkedList<Move> movimientosPadre2) {

		insertarMovimientosDeLos2Padres(movimientosPadre1, movimientosPadre2);
		
		System.out.println();
		System.out.println("Estos son los movimientos de los 2 padres:"+movimientosPadres.toString() );
		System.out.println();
		
		int posicionAleatoriaMovimientosPadres;

		// irá insertado en el hijo movimietos hasta que haya un maximo de 4 movimietos
		// en el hijo o no existan más movimietos para insertar ya que los padres poseen
		// entre
		// los dos menos de 4 movimientos
		while (movimientosPadres.size() > 0 && movimientosHijo.size() < 4) {

			// genera una posición aleatoria
			posicionAleatoriaMovimientosPadres = (int) (Math.random() * movimientosPadres.size());
			
			System.out.println("posicion aleatoria "+posicionAleatoriaMovimientosPadres);

			// añade el movimiento que se encuentra en la posición aleatoria generada
			// anteriormente
			System.out.println("movimiento añadido "+movimientosPadres.get(posicionAleatoriaMovimientosPadres).getName());
			movimientosHijo.add(movimientosPadres.get(posicionAleatoriaMovimientosPadres));
			System.out.println("movimitosHijo "+movimientosHijo.toString());

			// borra de los movimientos de los dos padres el movimiento insertado en el hijo
			// para que no lo tenga en cuenta en la siguiente insercción
			movimientosPadres.remove(posicionAleatoriaMovimientosPadres);
			System.out.println("movimientro padres despues de eliminar "+movimientosPadres.toString());

		}

	}

	// añade los movimietos del padre2 a la LinkedList<Move>movimientosPadres si no
	// se repite, si se repite comprueba cual tiene mayores valores y ese
	// es el que inserta en el hijo
	private static void insertarMovimientosPadre2(LinkedList<Move> movimientosPadre2) {

		// si entra en el if toma el valor true y por lo tanto está repetido el
		// movimieto y no lo inserta en la linkedlist de los movimietos de los dos
		// padres
		boolean existe; 

		for (int i = 0; i < movimientosPadre2.size(); i++) {
			
			existe=false;

			// comprueba que no coinciden los movimetos de los padres
			for (int j = 0; j < movimientosPadres.size(); j++) {

				if (movimientosPadre2.get(i).getName().equalsIgnoreCase(movimientosPadres.get(j).getName())) {

					existe = true;
//					break;
				}

				

			}
			if (existe==false) {
				
				movimientosPadres.add(movimientosPadre2.get(i));
			}
			System.out.println(movimientosPadre2.get(i).getName());
			System.out.println("movimientos del padre2: "+movimientosPadres.toString());
		}

	}

	// selecciona el nombre de pokemon del hijo a partir de uno de los padres
	private static String elegirAleatoriamenteNombrePokemonHijo(Pokemon pokemon1, Pokemon pokemon2) {

		String nombreHijo = "";

		int numAleatotio = (int) (Math.random() * 2);

		if (numAleatotio == 0)
			nombreHijo = pokemon1.getName();
		else
			nombreHijo = pokemon2.getName();
		return nombreHijo;

	}

	private static void insertarMovimientosDeLos2Padres(LinkedList<Move> movimientosPadre1,
			LinkedList<Move> movimientosPadre2) {

		insertraMovimietosPadre1(movimientosPadre1);

		insertarMovimientosPadre2(movimientosPadre2);

	}

}
