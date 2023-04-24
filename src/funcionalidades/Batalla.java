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

	// Devuelve true si el pokemon2 (pokemon defensor) ha muerto
	public static boolean atacar(Pokemon pokemon1, Pokemon pokemon2, Move movimientoPokemon1) {// , int VecesGanadas) {

		boolean muerto = false;
		// si el movimiento es de categoría ataque

		switch (movimientoPokemon1.getCategory()) {
		case "ATAQUE": {

			pokemon2.setVit(pokemon2.getVit() - movimientoPokemon1.getPower());

			if (pokemon2.getVit()<=0)
				muerto = true;

			return muerto;

		}
		case "ESTADO": {

			return muerto;
		}

		case "MEJORA": {

			return muerto;
		}
		default:
			return muerto;
		}

	}

//	private static void cambiarPokemon(Pokemon pokemon) {
//		
//		entrenador
//		
//		
//	}

}
