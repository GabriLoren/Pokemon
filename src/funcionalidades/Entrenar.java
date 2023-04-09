package funcionalidades;

import java.io.IOException;
import java.util.LinkedList;

import modelo.Pokemon;
import modelo.Trainer;

public class Entrenar {

	private static LinkedList<Pokemon> pokemons;

	private static Pokemon pokemonElegido;

	/**
	 * aumenta las estadísticas dependiendo del entrenamiento seleccionado
	 * 
	 * @param entrenador
	 * @param mote
	 * @param tipoDeEntrenamiento
	 * @throws IOException, NullPointerException
	 */
	public static void entrenar(Trainer entrenador, String mote, String tipoDeEntrenamiento)throws NullPointerException, IOException{

		boolean entrenamientoRealizado = false;

		pokemons = entrenador.getTodosLosPokemon();

		for (int i = 0; i < pokemons.size(); i++) {

			if (mote.equalsIgnoreCase(pokemons.get(i).getNickname())) {

				pokemonElegido = pokemons.get(i);

				System.out.println(pokemonElegido.toString());
				break;

			}else {
				System.out.println("el pokemon no existe");
			}

		}

		switch (tipoDeEntrenamiento) {
		case "pesado": {

			if ((entrenador.getPokeDollar() - (20 * pokemonElegido.getLevel())) < 0) {

				System.out.println("no hay suficiente dinero");
				System.out.println(entrenador.getPokeDollar());
			} else {

				pokemonElegido.setDef(pokemonElegido.getDef() + 5);
				pokemonElegido.setSpDef(pokemonElegido.getSpDef() + 5);
				pokemonElegido.setVit(pokemonElegido.getVit() + 5);
				entrenador.setPokeDollar(entrenador.getPokeDollar() - (20 * pokemonElegido.getLevel()));

			}

			break;
		}

		case "furioso": {

			if ((entrenador.getPokeDollar() - (30 * pokemonElegido.getLevel())) < 0) {

				System.out.println("no hay suficiente dinero");
				System.out.println(entrenador.getPokeDollar());
			} else {

				pokemonElegido.setAtk(pokemonElegido.getAtk() + 5);
				pokemonElegido.setSpAtk(pokemonElegido.getSpAtk() + 5);
				pokemonElegido.setSpeed(pokemonElegido.getSpeed() + 5);
				entrenador.setPokeDollar(entrenador.getPokeDollar() - (30 * pokemonElegido.getLevel()));
			}

			break;
		}
		case "funcional": {



			if ((entrenador.getPokeDollar() - (40 * pokemonElegido.getLevel())) < 0) {

				System.out.println("no hay suficiente dinero");
				System.out.println(entrenador.getPokeDollar());
			} else {
				
				pokemonElegido.setSpeed(pokemonElegido.getSpeed() + 5);
				pokemonElegido.setAtk(pokemonElegido.getAtk() + 5);
				pokemonElegido.setDef(pokemonElegido.getDef() + 5);
				pokemonElegido.setVit(pokemonElegido.getVit() + 5);
				
				entrenador.setPokeDollar(entrenador.getPokeDollar() - (40 * pokemonElegido.getLevel()));
			}

			break;
		}
		case "onirico": {

			
			if ((entrenador.getPokeDollar() - (40 * pokemonElegido.getLevel())) < 0) {

				System.out.println("no hay suficiente dinero");
				System.out.println(entrenador.getPokeDollar());
			} else {
				
				pokemonElegido.setSpeed(pokemonElegido.getSpeed() + 5);
				pokemonElegido.setSpAtk(pokemonElegido.getSpAtk() + 5);
				pokemonElegido.setSpDef(pokemonElegido.getSpDef() + 5);
				pokemonElegido.setVit(pokemonElegido.getVit() + 5);
				
				entrenador.setPokeDollar(entrenador.getPokeDollar() - (40 * pokemonElegido.getLevel()));
			}

			break;
		}
		default:{
			
			IOException noExisteEntrenamiento=new IOException();
			
			throw noExisteEntrenamiento;
			
		}
		}
		
	
	
		// actualiza la BbDd
		ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(pokemonElegido);

	}

}
