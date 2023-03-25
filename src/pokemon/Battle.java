package pokemon;

import java.util.Scanner;

public class Battle {

	private static int ganadasYo = 0;
	private static int ganadasOponente = 0;

	public void batallaCompleta(Pokemon[] myPokemon, Pokemon[] oponentPokemon) {

		int i = 0;
		int j = 0;
		int peleasRealizadas=0;
		Pokemon pokemonWinner; 

		do {
			peleasRealizadas++;
			
			System.out.println("miPokemon nº "+j+" vs "+" pokemonOponente nº "+i);
			pokemonWinner=pelea(myPokemon[j], oponentPokemon[i]);
			
			if (pokemonWinner == myPokemon[j]) {
				i++;
				System.out.println("La pelea número "+peleasRealizadas+" la has ganado tu");
			}
				

			else {
				j++;
				System.out.println("La pelea número "+peleasRealizadas+" la ha ganado tu oponente");
			}
				

		} while (ganadasYo < myPokemon.length || ganadasOponente < oponentPokemon.length);

	}

// ataque de un pokemon a su oponente
	public Pokemon pelea(Pokemon myPokemon, Pokemon oponentPokemon) {

		Pokemon pokemonWinner;

		do {

			checkMove(myPokemon, oponentPokemon);// , move);

			System.out.println("Vida oponente " + oponentPokemon.getVit());
			
			if(oponentPokemon.getVit()==0)break;

			checkMove(oponentPokemon, myPokemon);

			System.out.println("Vida mi pokemon " + myPokemon.getVit());

		} while (myPokemon.getVit() != 0 && oponentPokemon.getVit() != 0);
		

		if (myPokemon.getVit() != 0) {
			pokemonWinner = myPokemon;
			
		}

		else {
			pokemonWinner = oponentPokemon;
			
		}

		return pokemonWinner;
	}

//comprueba la categoria del ataque y ataca, el ataque solo tiene en cuenta el power del move
	public static void checkMove(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {// , Move move) {

		if (pokemonAtacante.getMove().getCategory() == Category.ATK) {

			int VitOponent = pokemonDefensor.getVit() - pokemonAtacante.getMove().getPower();

			pokemonDefensor.setVit(VitOponent);

		}
	}
}
