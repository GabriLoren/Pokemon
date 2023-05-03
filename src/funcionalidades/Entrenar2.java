package funcionalidades;

import modelo.Pokemon;
import modelo.Trainer;

public class Entrenar2 {

	/**
	 * @param entrenador
	 * @param tipoDeEntrenamiento
	 * @param pokemonElegido
	 * @return true si no hay suficiente dinero y false si se ha completado la
	 *         operación
	 */
	public static boolean tipoEntrenamiento(Trainer entrenador, String tipoDeEntrenamiento, Pokemon pokemonElegido) {

		boolean noSuficienteDinero = false;

		switch (tipoDeEntrenamiento.toLowerCase()) {
		case "pesado": {
			
			if ((entrenador.getPokeDollar() - (20 * pokemonElegido.getLevel())) < 0) {


				noSuficienteDinero = true;
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

				noSuficienteDinero = true;
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

				
				noSuficienteDinero = true;
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

		
				noSuficienteDinero = true;
			} else {

				pokemonElegido.setSpeed(pokemonElegido.getSpeed() + 5);
				pokemonElegido.setSpAtk(pokemonElegido.getSpAtk() + 5);
				pokemonElegido.setSpDef(pokemonElegido.getSpDef() + 5);
				pokemonElegido.setVit(pokemonElegido.getVit() + 5);

				entrenador.setPokeDollar(entrenador.getPokeDollar() - (40 * pokemonElegido.getLevel()));
			}

		break;
		}

		}

		// actualiza la BbDd
		ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(pokemonElegido);
		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(entrenador);
		return noSuficienteDinero;

	}

}
