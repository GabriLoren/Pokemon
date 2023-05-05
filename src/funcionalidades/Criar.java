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

	public static void Criar(Pokemon pokemon1, Pokemon pokemon2, Trainer entrenador) {

		Pokemon pokemonHijo = new Pokemon(0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null,"");

		// tendrá por defecto el nivel 1
		pokemonHijo.setLevel(1);

		// mote del pokemon
		pokemonHijo.setNickname(creaMoteHijo(pokemon1, pokemon2));

		// nombre del pokemon hijo
		pokemonHijo.setName(elegirAleatoriamenteNombrePokemonHijo(pokemon1, pokemon2));

		// Estadísticas
		insertarEstadisticasEnHijo(pokemon1, pokemon2, pokemonHijo);

		// movimientos
		insertarMovimientosEnHijo(pokemon1.getMoves(), pokemon2.getMoves());
		pokemonHijo.setMoves(movimientosHijo);

		// añadimos al entrenador el pokemon que acabamos de crear con la crianza
		entrenador.getTodosLosPokemon().add(pokemonHijo);

		// Reutilizamos el método de la clase captura para insertra en la BbDd el nuevo
		// pokemon creado
		// mediante de la crianza
		PokemonEntrenadorCrud.insertarEnBbDdElPokemonEncontrado(pokemonHijo, entrenador.getId());

		// Los padres pierden un punto de fertilidad cada vez que crien
		pokemon1.setFertility(pokemon1.getFertility() - 1);
		pokemon2.setFertility(pokemon2.getFertility() - 1);
		ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(pokemon1);
		ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(pokemon2);

	}

// añade los movimietos del padre1 a la LinkedList<Move>movimientosPadres
	private static void insertraMovimietosPadre1(LinkedList<Move> movimientosPadre1) {

		for (int i = 0; i < movimientosPadre1.size(); i++) {

			Move movimietoDelPadre = movimientosPadre1.get(i);
			movimientosPadres.add(movimietoDelPadre);

			System.out.println("movimientos del padre1: " + movimientosPadres.toString());
		}

	}

	// Inserta en el hijo movimietos hasta un máximo de 4 a partir de la linkedlist
	// creada con los movimientos de los dos padres
	private static void insertarMovimientosEnHijo(LinkedList<Move> movimientosPadre1,
			LinkedList<Move> movimientosPadre2) {

		insertarMovimientosDeLos2Padres(movimientosPadre1, movimientosPadre2);

		System.out.println();
		System.out.println("Estos son los movimientos de los 2 padres:" + movimientosPadres.toString());
		System.out.println();

		int posicionAleatoriaMovimientosPadres;

		// irá insertado en el hijo movimietos hasta que haya un maximo de 4 movimietos
		// en el hijo o no existan más movimietos para insertar ya que los padres poseen
		// entre
		// los dos menos de 4 movimientos
		while (movimientosPadres.size() > 0 && movimientosHijo.size() < 4) {

			// genera una posición aleatoria
			posicionAleatoriaMovimientosPadres = (int) (Math.random() * movimientosPadres.size());

			System.out.println("posicion aleatoria " + posicionAleatoriaMovimientosPadres);

			// añade el movimiento que se encuentra en la posición aleatoria generada
			// anteriormente
			System.out.println(
					"movimiento añadido " + movimientosPadres.get(posicionAleatoriaMovimientosPadres).getName());
			movimientosHijo.add(movimientosPadres.get(posicionAleatoriaMovimientosPadres));
			System.out.println("movimitosHijo " + movimientosHijo.toString());

			// borra de los movimientos de los dos padres el movimiento insertado en el hijo
			// para que no lo tenga en cuenta en la siguiente insercción
			movimientosPadres.remove(posicionAleatoriaMovimientosPadres);
			System.out.println("movimientro padres despues de eliminar " + movimientosPadres.toString());

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

			existe = false;

			// comprueba que no coinciden los movimetos de los padres
			for (int j = 0; j < movimientosPadres.size(); j++) {

				if (movimientosPadre2.get(i).getName().equalsIgnoreCase(movimientosPadres.get(j).getName())) {

					existe = true;
//					break;
				}

			}
			if (existe == false) {

				movimientosPadres.add(movimientosPadre2.get(i));
			}
			System.out.println(movimientosPadre2.get(i).getName());
			System.out.println("movimientos del padre2: " + movimientosPadres.toString());
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

	// Devuelve un String creado con la unión de la primera mitad del mote de cada
	// padre siendo la primera
	// parte del String la primera mitad de uno de los motes de los padres
	// seleccionado aleatoriamente
	private static String creaMoteHijo(Pokemon pokemon1, Pokemon pokemon2) {

		String moteHijo;

		// Devuelve un String con la primera mitad del mote del pokemon1
		String mitaMote1 = recorreMote(pokemon1);
		// Devuelve un String con la primera mitad del mote del padre pokemon2
		String mitaMote2 = recorreMote(pokemon2);

		// Genera un número aleatorio que pued ser un 0 o un 1;
		int aleatorio = (int) (Math.random() * 2);

		// Si sale un 0 la primera parte del mote será la primera mitad del mote del
		// pokemon1
		// y si sale un 1 la primera parte del mote será la primera mitad del mote del
		// pokemon2

		if (aleatorio == 0)
			moteHijo = mitaMote1 + mitaMote2;
		else
			moteHijo = mitaMote2 + mitaMote1;

		return moteHijo;

	}

	// Devuelve un String con la primera mitad del mote del padre
	private static String recorreMote(Pokemon pokemonPadre) {

		String motePadre = pokemonPadre.getNickname();

		int mitadNumLetrasMotePadre = motePadre.length() / 2;

		if (mitadNumLetrasMotePadre < 1)
			mitadNumLetrasMotePadre = 1;

		String mitaMote = "";

		for (int i = 0; i < mitadNumLetrasMotePadre; i++) {

			mitaMote += motePadre.charAt(i);

		}
		System.out.println(mitaMote);
		return mitaMote;
	}

	// Se inserta en el hijo las estadísticas del padre que sean de mayor valor
	private static void insertarEstadisticasEnHijo(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemonHijo) {

		// vitalidad
		if (pokemon1.getVit() > pokemon2.getVit())
			pokemonHijo.setVit(pokemon1.getVit());
		else
			pokemonHijo.setVit(pokemon2.getVit());

		// ataque
		if (pokemon1.getAtk() > pokemon2.getAtk())
			pokemonHijo.setAtk(pokemon1.getAtk());
		else
			pokemonHijo.setAtk(pokemon2.getAtk());

		// defensa
		if (pokemon1.getDef() > pokemon2.getDef())
			pokemonHijo.setDef(pokemon1.getDef());
		else
			pokemonHijo.setDef(pokemon2.getDef());

		// spAtk
		if (pokemon1.getSpAtk() > pokemon2.getSpAtk())
			pokemonHijo.setSpAtk(pokemon1.getSpAtk());
		else
			pokemonHijo.setSpAtk(pokemon2.getSpAtk());
		// spDef
		if (pokemon1.getSpDef() > pokemon2.getSpDef())
			pokemonHijo.setSpDef(pokemon1.getSpDef());
		else
			pokemonHijo.setSpDef(pokemon2.getSpDef());

		// velocidad
		if (pokemon1.getSpeed() > pokemon2.getSpeed())
			pokemonHijo.setSpeed(pokemon1.getSpeed());
		else
			pokemonHijo.setSpeed(pokemon2.getSpeed());

		// stamina
		if (pokemon1.getStamina() > pokemon2.getStamina())
			pokemonHijo.setStamina(pokemon1.getStamina());
		else
			pokemonHijo.setStamina(pokemon2.getStamina());

		// fertilidad, el hijo tendrá la mayor de los dos padres antes de que se le reste uno, ya que
		//cada vez que crían los padres pierden un punto de fertilidad
		if (pokemon1.getFertility() > pokemon2.getFertility())
			pokemonHijo.setFertility(pokemon1.getFertility());
		else
			pokemonHijo.setFertility(pokemon2.getStamina());

	}
	
	
	

}
