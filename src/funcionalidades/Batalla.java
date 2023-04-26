package funcionalidades;

import java.util.LinkedList;

import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;

public class Batalla {

	private LinkedList<Pokemon> equipoJugador = new LinkedList<Pokemon>();

	private LinkedList<Pokemon> equipoContrincante = new LinkedList<Pokemon>();

	public void batalla(Trainer jugador, Trainer contrincante) {

		int vecesGanadasusuario = 0;
		int vecesGanadascontrincante = 0;

//		atacar(null, null, null, vecesGanadascontrincante);

	}

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
	public static boolean atacar(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1, int turnos) {

		if (comprobarEstado(pokemon1, turnos)) {
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

		}
		case "ESTADO": {
			
			pokemon2.setStatus(movimientoPokemon1.getName()); 
		}

		case "MEJORA": {

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
	// devuelve false si al pokemon turno que le corresponde atacar no puede
	// debido a que se encuentra en un estado que se lo impide
	private static boolean comprobarEstado(Pokemon pokemon, int turnos) {
		
		boolean puedeAtacar = true;

		
		switch (pokemon.getStatus()) {
		case "CONGELADO": {

			puedeAtacar = false;

			// tiene un 20% de probabilidad de descongelarse, si sale 0 se descongela
			int seHadescongelado = (int) (Math.random() * 5);

			if (seHadescongelado == 0)
				pokemon.setStatus("SINESTADO");
			else
				System.out.println("ESTA CONGELADO");
			
			turnos++;
			
			if(turnos==3) {
				pokemon.setStatus("SINESTADO");
				turnos=0;
			}

			
		}
		default:

			
			puedeAtacar=true;
		}
		return puedeAtacar;
	}
	
	

//	private static void cambiarPokemon(Pokemon pokemon) {
//		
//		entrenador
//		
//		
//	}

}
