package pokemon;

import java.lang.annotation.Retention;
import java.util.LinkedList;
import java.util.Scanner;

public class Battle {

	private static int ganadasYo = 0;
	private static int ganadasOponente = 0;
	private static Trainer trainer;
	private static boolean winner;
	private Trainer trainer1;
	private Trainer trainer2;
//	private LinkedList<Turn>;

//	public Battle() {
//		super();
//		this.trainer1 = new Trainer();
//		this.trainer2 = new Trainer();
//	}

	public Battle(Trainer trainer1, Trainer trainer2) {
		super();
		this.trainer1 = trainer1;
		this.trainer2 = trainer2;
	}

	public void trainer1VsTrainer2() {

		winner = batallaCompleta(trainer1.getEquipoPokemon(), trainer2.getEquipoPokemon());

		if (winner)
			System.out.println("Enhorabuena has ganado la batalla");
		else
			System.out.println("Has perdido, otra vez será");

	}

//si el pokemon de uno de los trainer sobrevive, sigue luchando y el trainer que a perdido la lucha
//	elige otro pokemon para seguir luchando
	public boolean batallaCompleta(LinkedList<Pokemon> misPokemon, LinkedList<Pokemon> oponentPokemon) {

		int i = 0;
		int j = 0;
		int peleasRealizadas = 0;
		Pokemon pokemonWinner;

		do {
			peleasRealizadas++;

			System.out.println("miPokemon nº " + i + " vs " + " pokemonOponente nº " + j);
			pokemonWinner = pelea(misPokemon.get(i), oponentPokemon.get(j));

			if (pokemonWinner == misPokemon.get(i)) {
				j++;
				System.out.println("La pelea número " + peleasRealizadas + " la has ganado tu");

			}

			else {
				i++;
				System.out.println("La pelea número " + peleasRealizadas + " la ha ganado tu oponente");
			}

		} while (ganadasYo < oponentPokemon.size() && ganadasOponente < misPokemon.size());

		if (ganadasYo > ganadasOponente)
			return true;
		else
			return false;
	}

// ataque de un pokemon a su oponente
	public Pokemon pelea(Pokemon myPokemon, Pokemon oponentPokemon) {

		Pokemon pokemonWinner;
		System.out.println("Vida oponente " + oponentPokemon.getVit());
		System.out.println("Vida mi pokemon " + myPokemon.getVit());
		while (myPokemon.getVit() != 0 && oponentPokemon.getVit() != 0) {

			checkMove(myPokemon, oponentPokemon);// , move);

			System.out.println("Vida oponente " + oponentPokemon.getVit());

			if (oponentPokemon.getVit() == 0)
				break;

			checkMove(oponentPokemon, myPokemon);

			System.out.println("Vida mi pokemon " + myPokemon.getVit());
		}

		if (myPokemon.getVit() != 0) {
			pokemonWinner = myPokemon;
			ganadasYo++;
		}

		else {
			pokemonWinner = oponentPokemon;
			ganadasOponente++;
		}

		return pokemonWinner;
	}

//comprueba la categoria del ataque y ataca, el ataque solo tiene en cuenta el power del move
	public static void checkMove(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {// , Move move) {

		// formula provisional ataque= (vit pokemonDefensor)-(power atk pokemon
		// atacante)
		if (pokemonAtacante.getMove().getCategory() == Category.ATK) {

			int VitOponent = pokemonDefensor.getVit()
					- (pokemonAtacante.getMove().getPower() + pokemonAtacante.getAtk());

			pokemonDefensor.setVit(VitOponent);

		}
	}
}
