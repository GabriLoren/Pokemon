package pokemon;

import java.util.Scanner;

public class Battle {

// ataque de un pokemon a su oponente
	public void pelea(Pokemon myPokemon, Pokemon oponentPokemon, Move move) {

		Scanner sc = new Scanner(System.in);

		do {

			checkMove(myPokemon, oponentPokemon, move);

			System.out.println(oponentPokemon.getVit());

			checkMove(oponentPokemon, myPokemon, move);

			System.out.println(oponentPokemon.getVit());

		} while (myPokemon.getVit() != 0 && oponentPokemon.getVit() != 0);

	}

//comprueba la categoria del ataque
	public static void checkMove(Pokemon myPokemon, Pokemon oponentPokemon, Move move) {

		if (move.getCategory() == Category.ATK) {

			int VitOponent = oponentPokemon.getVit() - move.getPower();

			oponentPokemon.setVit(VitOponent);

		}
	}
}
