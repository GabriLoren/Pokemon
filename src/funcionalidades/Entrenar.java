package funcionalidades;

import java.util.LinkedList;

import modelo.Pokemon;
import modelo.Trainer;

public class Entrenar {

	private static LinkedList<Pokemon> pokemons;

	private static Pokemon pokemonElegido;

/**
 * aumenta las estadísticas dependiendo del entrenamiento seleccionado
 * @param entrenador
 * @param mote
 * @param tipoDeEntrenamiento
 */
	public static void entrenar(Trainer entrenador, String mote, String tipoDeEntrenamiento) {
		
		boolean entrenamientoRealizado=false;

		pokemons = entrenador.getTodosLosPokemon();

		for (int i = 0; i < pokemons.size(); i++) {

			if (mote.toUpperCase().equalsIgnoreCase(pokemons.get(i).getNickname()))
				;
			{

				pokemonElegido = pokemons.get(i);
				break;

			}
		 
		}

		switch (tipoDeEntrenamiento.toLowerCase()) {
		case "pesado": {

			pokemonElegido.setDef(pokemonElegido.getDef() + 5);
			pokemonElegido.setSpDef(pokemonElegido.getSpDef() + 5);
			pokemonElegido.setVit(pokemonElegido.getVit() + 5);

			entrenador.setPokeDollar(entrenador.getPokeDollar() - (20 * pokemonElegido.getLevel()));

			break;
		}

		case "furioso": {

			break;
		}
		case "funcional": {

			break;
		}
		case "onírico": {

			break;
		}
		}

	}

}
