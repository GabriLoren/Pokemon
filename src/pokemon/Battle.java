package pokemon;

import java.lang.annotation.Retention;
import java.util.Scanner;

public class Battle {

	private static int ganadasYo = 0;
	private static int ganadasOponente = 0;
	private static Trainer trainer;
	private static boolean winner;
	private Trainer trainer1;
	private Trainer trainer2;
	
	public Battle() {
		super();
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
	}
	
	
	public Battle(Trainer trainer1, Trainer trainer2) {
		super();
		this.trainer1 = trainer1;
		this.trainer2 = trainer2;
	}

	public void trainer1VsTrainer2(){
		
		
		winner= batallaCompleta(trainer1.getEquipoPokemon(), trainer2.getEquipoPokemon());
		 
		if(winner)System.out.println("Enhorabuena has ganado la batalla");
		else System.out.println("Has perdido, otra vez será");
		
	}

	public boolean batallaCompleta(Pokemon[] myPokemon, Pokemon[] oponentPokemon) {

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
				

		} while (ganadasYo < myPokemon.length && ganadasOponente < oponentPokemon.length);

		
		if(ganadasYo>ganadasOponente)
		 return true;
		else return false;
	}

// ataque de un pokemon a su oponente
	public Pokemon pelea(Pokemon myPokemon, Pokemon oponentPokemon) {

		Pokemon pokemonWinner;
		System.out.println("Vida oponente " + oponentPokemon.getVit());
		System.out.println("Vida mi pokemon " + myPokemon.getVit());
		do {
			
			
			checkMove(myPokemon, oponentPokemon);// , move);

			System.out.println("Vida oponente " + oponentPokemon.getVit());
			
			if(oponentPokemon.getVit()==0)break;

			checkMove(oponentPokemon, myPokemon);

			System.out.println("Vida mi pokemon " + myPokemon.getVit());

		} while (myPokemon.getVit() != 0 && oponentPokemon.getVit() != 0);
		

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

		if (pokemonAtacante.getMove().getCategory() == Category.ATK) {

			int VitOponent = pokemonDefensor.getVit() - pokemonAtacante.getMove().getPower();

			pokemonDefensor.setVit(VitOponent);

		}
	}
}
