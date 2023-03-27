package modelo;

import java.lang.annotation.Retention;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class Battle {

	private static int ganadasYo = 0;
	private static int ganadasOponente = 0;
	private static Trainer trainer;
	private static boolean winner;
	private static Trainer trainer1;
	private static Trainer trainer2;
//	private LinkedList<Turn>;

//	public Battle() {
//		super();
//		this.trainer1 = new Trainer();
//		this.trainer2 = new Trainer();
//	}

	//gana el entrenador que acaba antes con los pokemon del oponente independientemente del número de pokemon
	//que tenga cada uno
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
		
		System.out.println("ganadas tu: "+ganadasYo);
		System.out.println("ganadas oponente: "+ganadasOponente);

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

		if (ganadasYo == oponentPokemon.size())
			return true;
		else
			return false;
	}

// ataque de un pokemon a su oponente
	public Pokemon pelea(Pokemon myPokemon, Pokemon oponentPokemon) {

		Pokemon pokemonWinner;
		System.out.println("Vida oponente " + oponentPokemon.getVit());
		System.out.println("Vida mi pokemon " + myPokemon.getVit());
		while (myPokemon.getVit() > 0 && oponentPokemon.getVit() > 0) {

			checkMove(myPokemon, oponentPokemon);// , move);

			System.out.println("Vida oponente " + oponentPokemon.getVit());

			if (oponentPokemon.getVit() <= 0)
				break;

			checkMove(oponentPokemon, myPokemon);

			System.out.println("Vida mi pokemon " + myPokemon.getVit());
		}

		if (myPokemon.getVit() > 0) {
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
		
		Move movimientoSeleccionado;
		
		if(pokemonAtacante == trainer1.getEquipoPokemon().get(0)||
				pokemonAtacante == trainer1.getEquipoPokemon().get(1)||
				pokemonAtacante == trainer1.getEquipoPokemon().get(2)) {
			System.out.println(trainer1.getEquipoPokemon().get(0).toString());
			
			
			
			movimientoSeleccionado= seleccionaMovimiento(pokemonAtacante);
			
		}
		
		else movimientoSeleccionado = moveAleatorio( pokemonAtacante);
			
		
		

		if (movimientoSeleccionado.getCategory() == Category.ATK) {

			int VitOponent = pokemonDefensor.getVit() - (movimientoSeleccionado.getPower() + pokemonAtacante.getAtk());

			pokemonDefensor.setVit(VitOponent);

		}
	}

//seleccionamos el movimieto que vamos a utilizar en nuestro turno	
	public static Move seleccionaMovimiento(Pokemon pokemonAtacante) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Selecciona el movimiento que quieres utilizar");

//		int i = 0;
//		while (i < pokemonAtacante.getMoves().size()) {
//
//			System.out.print("Posición " + i + " ");
//			System.out.println(pokemonAtacante.getMoves().get(i).toString());
//
//			i++;
//		}
	
//		EscenaPrincipalController.returnn();
		
		int entero=EscenaPrincipalController.patada(null);
		
		// introducimos por scaner la posicion del movimiento seleccionado
		Move movimientoSeleccionado = pokemonAtacante.getMoves().get(entero);
		
//		Move movimientoSeleccionado = pokemonAtacante.getMoves().get(sc.nextInt());

		return movimientoSeleccionado;

	}
// seleciona un movimiento del contricante aleatoriamente
	public static Move moveAleatorio(Pokemon pokemonAtacante) {
		
		int posicionAleatoria=(int) (Math.random()*3);
		
		Move movimientoSeleccionado = pokemonAtacante.getMoves().get(posicionAleatoria);
		
		System.out.println("tu oponente ha elegido el movimiento "+movimientoSeleccionado.toString());
		
		return movimientoSeleccionado;
	}
}
