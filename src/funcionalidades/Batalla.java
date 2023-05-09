package funcionalidades;

import java.util.LinkedList;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.DmgTypes;
import modelo.Move;
import modelo.Pokemon;
import modelo.Status;
import modelo.Trainer;
import modelo.TypeChart;

public class Batalla {

	// Generates a random number and has a 17 / 256 chance of being a critical hit
	private static int critChance() {
		boolean crit = false;
		Random rnd = new Random();
		int low = 0;
		int high = 256;
		int result = rnd.nextInt(high - low) + low;
		for (int i = 0; i < 17; i++) {
			if (result == i) {
				crit = true;
			}
		}
		if (crit) {
			return 2;
		} else {
			return 1;
		}
	}

	// Checks if a pokemon's move shares type with any of the pokemon types and if
	// it does it returns 1.5 otherwise it returns 1
	private static double stab(Pokemon p, Move m) {
		if (p.getType1().equals(m.getType()) || p.getType2().equals(m.getType())) {
			return 1.5;
		} else {
			return 1;
		}
	}

	// Generates a random number between 217 and 255, then checks if the previous
	// steps of the damage formula equal 1, if it does it returns 1 otherwise it
	// returns the generated number divided by 255
	private static int dmgRnd(Pokemon p, Pokemon r, Move m) {
		Random rnd = new Random();
		int low = 217;
		int high = 255;
		int result = rnd.nextInt(high - low) + low;
		if (m.getDmgTypes().equals(DmgTypes.PHYSICAL)) {
			if ((int) ((((((2 * p.getLevel() * (critChance())) / 5) + 2) * m.getPower() * (p.getAtk() / r.getDef()))
					/ 50 + 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType())) == 1) {
				return 1;
			} else {
				return result / 255;
			}
		} else {
			if ((int) ((((((2 * p.getLevel() * (critChance())) / 5) + 2) * m.getPower() * (p.getSpAtk() / r.getSpDef()))
					/ 50 + 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType())) == 1) {
				return 1;
			} else {
				return result / 255;
			}
		}
	}

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
	 * @param pokemon1           pokemon atacante
	 * @param pokemon2           pokemon defensor
	 * @param movimientoPokemon1 movimiento elegido en ese turno
	 * @return true si ha podido efectuar un movimiento y false si no ha podido
	 *         debido a que se encuentra en un estado que se lo impide y pasa el
	 *         turno sin atacar
	 */
	public static boolean atacar(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {

		if (turnos == 3 && pokemon1.getStatus().equals(Status.FREEZE)) {
			pokemon1.setStatus(null);
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
		case ATTACK: {

			pokemon2.setVit(pokemon2.getVit() - dmg(pokemon1, pokemon2, movimientoPokemon1));

			break;
		}
		case STATUS: {

			pokemon2.setStatus(movimientoPokemon1.getStatus());
			turnos = 0;

			break;
		}

		case BUFF: {
			switch (movimientoPokemon1.getStat()) {
			case ATTACK:
				pokemon1.setAtk((int) (pokemon1.getAtk() * movimientoPokemon1.getBuff()));
				break;
			case DEFENSE:
				pokemon1.setDef((int) (pokemon1.getDef() * movimientoPokemon1.getBuff()));
				break;
			case SPECIAL_ATTACK:
				pokemon1.setSpAtk((int) (pokemon1.getSpAtk() * movimientoPokemon1.getBuff()));
				break;
			case SPECIAL_DEFENSE:
				pokemon1.setSpDef((int) (pokemon1.getSpDef() * movimientoPokemon1.getBuff()));
				break;
			case SPEED:
				pokemon1.setSpeed((int) (pokemon1.getSpeed() * movimientoPokemon1.getBuff()));
				break;
			default:
				break;
			}
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
		case FREEZE: {

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
		case FLINCHED: {

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

	// This is the official way of calculating the damage of attack moves on
	// generation
	// 1 pokemon. Formula:
	// https://bulbapedia.bulbagarden.net/wiki/Damage#Generation_I
	public static int dmg(Pokemon p, Pokemon r, Move m) {
		int dmg = 0;
		if (m.getDmgTypes().equals(DmgTypes.PHYSICAL)) {
			dmg = (int) ((((((2 * p.getLevel() * (critChance())) / 5) + 2) * m.getPower() * (p.getAtk() / r.getDef()))
					/ 50 + 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType()) * dmgRnd(p, r, m));
		} else {
			dmg = (int) ((((((2 * p.getLevel() * (critChance())) / 5) + 2) * m.getPower()
					* (p.getSpAtk() / r.getSpDef())) / 50 + 2) * stab(p, m)
					* TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType()) * dmgRnd(p, r, m));
		}
		return dmg;
	}

	// Active pokemon gets experience after defeating a pokemon based on the
	// following formula ([POKEMON_LEVEL] + [RIVAL_POKEMON_LEVEL] * 10) / 4, then if
	// the exp value of the pokemon exceeds or equals its level times 10 it levels
	// up
	public void giveExp(Pokemon p1, Pokemon p2) {
		p1.setExp(p1.getExp() + ((p1.getLevel() + p2.getLevel() * 10) / 4));
		while (p1.getExp() >= (p1.getLevel() * 10)) {
			p1.levelUp();
		}
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
