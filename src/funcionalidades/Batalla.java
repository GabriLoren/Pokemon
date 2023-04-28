package funcionalidades;

import java.util.LinkedList;

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
	 * @param pokemon1           pokemon atacante
	 * @param pokemon2           pokemon defensor
	 * @param movimientoPokemon1 movimiento elegido en ese turno
	 * @return true si ha podido efectuar un movimiento y false si no ha podido
	 *         debido a que se encuentra en un estado que se lo impide y pasa el
	 *         turno sin atacar
	 */
	public static boolean atacar(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {

		if (comprobarEstado(pokemon1)) {
			Elegirataque(pokemon1, pokemon2, movimientoPokemon1);
			return true;
		} else
			return false;

	}

	// Segun el movimiento elegido se ejecutará un bloque distinto
	private static void Elegirataque(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {

		switch (movimientoPokemon1.getCategory()) {
		case "ATAQUE": {

			pokemon2.setVit(pokemon2.getVit() - movimientoPokemon1.getPower());

			break;
		}
		case "ESTADO": {

			pokemon2.setStatus(movimientoPokemon1.getName());
			break;
		}

		case "MEJORA": {
			break;

		}
		default:

		}

	}

	// crea una copia del equipo de pokemon ya que no queremos modificar
	// permanentemente la vitalidad
	// de los pokemon y el estado
	public static LinkedList<Pokemon> copiaEquipoPokemon(LinkedList<Pokemon> equipokemon) {

		LinkedList<Pokemon> copiaquiEpokemon = new LinkedList<Pokemon>();

		for (int i = 0; i < equipokemon.size(); i++) {

			Pokemon p = new Pokemon(equipokemon.get(i));

			copiaquiEpokemon.add(p);

		}
		return copiaquiEpokemon;
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

			if (turnos == 3) {
				pokemon.setStatus("SINESTADO");
				turnos = 0;
			}
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

}
