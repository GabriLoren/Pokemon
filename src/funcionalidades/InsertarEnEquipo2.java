package funcionalidades;

import crud.PokemonEntrenadorCrud;
import modelo.Pokemon;
import modelo.Trainer;

public class InsertarEnEquipo2 {

	// inserta el pokemon seleccionado en el equip pokemon y o borra de
	// TodosLosPokemon
	public static void inserarEnEquipo(int idPokemon, Trainer entrenador) {
		


		for (int i = 0; i < entrenador.getTodosLosPokemon().size(); i++) {

			if (idPokemon == entrenador.getTodosLosPokemon().get(i).getId()) {

				entrenador.getEquipoPokemon().add(entrenador.getTodosLosPokemon().get(i));

				entrenador.getEquipoPokemon().getLast().setEquipo("SI");

				entrenador.getTodosLosPokemon().remove(entrenador.getTodosLosPokemon().get(i));

				System.out.println("mote2 "+entrenador.getEquipoPokemon().getLast().getNickname());
				
				PokemonEntrenadorCrud.actualizarPokemonEnBbDd(entrenador.getEquipoPokemon().getLast());

			}

		}

	}

	public static void sacarDeEquipo(int idPokemon, Trainer entrenador) {

		for (int i = 0; i < entrenador.getEquipoPokemon().size(); i++) {

			if (idPokemon==entrenador.getEquipoPokemon().get(i).getId()) {
				
				entrenador.getTodosLosPokemon().add(entrenador.getEquipoPokemon().get(i));

				entrenador.getEquipoPokemon().remove(entrenador.getEquipoPokemon().get(i));

				entrenador.getTodosLosPokemon().getLast().setEquipo("NO");

				PokemonEntrenadorCrud.actualizarPokemonEnBbDd(entrenador.getTodosLosPokemon().getLast());

			}
		}
	}
	
	public static void sacarDeEquipo2(Pokemon pokemon, Trainer entrenador) {
				
				entrenador.getTodosLosPokemon().add(pokemon);

				entrenador.getEquipoPokemon().remove(pokemon);

				entrenador.getTodosLosPokemon().getLast().setEquipo("NO");

				PokemonEntrenadorCrud.actualizarPokemonEnBbDd(entrenador.getTodosLosPokemon().getLast());
				
				System.out.println(entrenador.getEquipoPokemon().size());

			
		
	}

}
