package funcionalidades;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;


public class Batalla {

	private static int turnos = 0;

//	private LinkedList<Pokemon> equipoJugador = new LinkedList<Pokemon>();
//
//	private LinkedList<Pokemon> equipoContrincante = new LinkedList<Pokemon>();
//
//	public void batalla(Trainer jugador, Trainer contrincante) {
//
//		int vecesGanadasusuario = 0;
//		int vecesGanadascontrincante = 0;
//
////		atacar(null, null, null, vecesGanadascontrincante);
//
//	}

	/**
	 * @param pokemonAtacado
	 * @return true si el pokemon atcado ha muerto y false si aún le queda vida
	 */
	public static boolean vidaPokemonAtacado(Pokemon pokemonAtacado) {

		if (pokemonAtacado.getVit() <= 0)
			return true;
		else
			return false;

	}

	/**
	 * @param pokemon1 pokemon atacante
	 * @param pokemon2 pokemon defensor
	 * @param movimientoPokemon1 movimiento elegido en ese turno
	 * @return true si ha podido efectuar un movimiento y false si no ha podido
	 *         debido a que se encuentra en un estado que se lo impide y pasa el
	 *         turno sin atacar
	 */
	public static boolean atacar(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {

		if (turnos == 3 && pokemon1.getStatus().equals("CONGELADO")) {
			pokemon1.setStatus("SINESTADO");
			turnos = 0;
		}

		System.out.println("estado del pokemon atacante " + pokemon1.getStatus());

		if (comprobarEstado(pokemon1)) {
			// resta la estamina que consume le movimiento
			pokemon1.setStamina(pokemon1.getStamina() - movimientoPokemon1.getStaminaCost());
			elegirAtaque(pokemon1, pokemon2, movimientoPokemon1);

			return true;
		} else
			return false;

	}
	// la maquina elige un movimiento aleatorio
//	public static boolean atacarMaquina(Pokemon pokemonMaquina, Pokemon PokemonJugador, Move movimientoMaquina) {
//		
//		LinkedList<Move> movimientosPokemonMaquina=pokemonMaquina.getMoves();
//		
//		int posicionMovimiento=(int)(Math.random()*(movimientosPokemonMaquina.size()));
//		
//		Move movimientoElegido=movimientosPokemonMaquina.get(posicionMovimiento);
//
//		if (comprobarEstado(pokemonMaquina)) {
//			elegirataque(pokemonMaquina, PokemonJugador, movimientoElegido);
//			return true;
//		} else
//			return false;
//
//	}

	// Segun el movimiento elegido se ejecutará un bloque distinto
	private static void elegirAtaque(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {

		switch (movimientoPokemon1.getCategory()) {
		case "ATAQUE": {

			pokemon2.setVit(pokemon2.getVit() - movimientoPokemon1.getPower());

			break;
		}
		case "ESTADO": {

			pokemon2.setStatus(movimientoPokemon1.getName());
			turnos = 0;

			break;
		}

		case "MEJORA": {
			break;

		}
		default:

		}

	}

	// comprueba el estado que tiene el pokemon que va a atacar
	// devuelve false si al pokemon que le corresponde atacar no puede
	// debido a que se encuentra en un estado que se lo impide
	private static boolean comprobarEstado(Pokemon pokemon) {

		boolean puedeAtacar = true;

		switch (pokemon.getStatus()) {
		case "CONGELADO": {

			puedeAtacar = false;
//			
//			int seHadescongelado = (int) (Math.random() * 5);
//
//			if (seHadescongelado == 0)
//				pokemon.setStatus("SINESTADO");
//			else
//				System.out.println("ESTA CONGELADO");
			turnos++;

			System.out.println("turnos de estadso " + turnos);

			break;

		}
		case "ATURDIDO": {

			puedeAtacar = false;

			turnos++;

			break;

		}
		default:

			puedeAtacar = true;
		}
		return puedeAtacar;
	}

	// si no hay suficiente estamina para realizar el movimiento delvuelve false
	public static boolean comprobraEstamina(Pokemon pokemon, Move movimiento) {

		if (pokemon.getStamina() >= movimiento.getStaminaCost())
			return true;
		else

			return false;
	}

	public static Move movimientoAleatorioMaquina(Pokemon pokemonMaquina) {

		LinkedList<Move> movimientosPokemonMaquina = pokemonMaquina.getMoves();

		int posicionMovimiento = (int) (Math.random() * (movimientosPokemonMaquina.size()));

		Move movimientoElegido = movimientosPokemonMaquina.get(posicionMovimiento);

		return movimientoElegido;
	}

	/**
	 * Inserta los elementos de la LinkedList pasada por parámetro en la
	 * ObservableList
	 * 
	 * @return lista que queremos motrar en la tableView
	 */
	public static ObservableList<Move> mostrarTableView(LinkedList<Move> listaLinkedList) {

		ObservableList<Move> listaObservableList = FXCollections.observableArrayList();

		for (int i = 0; i < listaLinkedList.size(); i++) {

			listaObservableList.add(listaLinkedList.get(i));

		}
		return listaObservableList;
	}

	/**
	 * restablece la vida de los pokemon despues del combate
	 */
	public static void restablecerVidaYEstamina(LinkedList<Pokemon> equipo) {

		for (int i = 0; i < equipo.size(); i++) {

			equipo.get(i).setVit(100);
			equipo.get(i).setStamina(100);

		}

	}

	/**
	 * El entrenador que pierda el combate entrega al entrenador ganador 1/3 de su
	 * número de pokédollars en valor entero
	 */
	public static void premioGanadorBatalla(Trainer ganador, Trainer perdedor) {

		int premio = perdedor.getPokeDollar() / 3;

		ganador.setPokeDollar(ganador.getPokeDollar() + premio);

		perdedor.setPokeDollar(perdedor.getPokeDollar() - premio);

		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(ganador);

		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(perdedor);

	}

//	/**
//	 * @param equipoPokemon
//	 * @return lista con la copia de los pokemon que hay en el equipo que se pasa por parámetro
//	 */
//	public static LinkedList<Pokemon> copiarEquipoPokemon(LinkedList<Pokemon>equipoPokemon) {
//		
//		LinkedList<Pokemon>equipoPokemonCopia=new LinkedList<Pokemon>();
//		
//		for(int i=0;i<equipoPokemon.size();i++) {
//			
//			Pokemon p=new Pokemon(equipoPokemon.get(i));
//			
//			equipoPokemonCopia.add(p);
//			
//		}
//		return equipoPokemonCopia;
//		
//		
//		
//	}

}
