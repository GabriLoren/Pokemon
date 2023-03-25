package pokemon;

import java.util.LinkedList;

public class MainPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Obj obj = new Obj(1, "piedra", 0, 1.5, 0, 0, 0);

		Move move1 = new Move();
		move1.setName(null);

		Move move2 = new Move("cabezazo",1, Category.ATK, 20, Types.NORMAL, "", 0, 0);
		
		Move move3 = new Move("puñetazo",1, Category.ATK, 30, Types.NORMAL, "", 0, 0);
		
		LinkedList<Move> moves= new LinkedList<Move>();
		
		moves.add(move1);
		moves.add(move2);
		moves.add(move3);
		

		Pokemon myPokemon1 = new Pokemon(moves);
		Pokemon myPokemon2 = new Pokemon(moves);
		Pokemon myPokemon3 = new Pokemon(moves);
		
		Pokemon pokemonOponente1 = new Pokemon(moves);
		Pokemon pokemonOponente2 = new Pokemon(moves);
		Pokemon pokemonOponente3 = new Pokemon(moves);
		
		LinkedList<Pokemon> equipoPokemon1= new LinkedList<Pokemon>();
		LinkedList<Pokemon> equipoPokemon2= new LinkedList<Pokemon>();
		
		equipoPokemon1.add(myPokemon1);
		equipoPokemon1.add(myPokemon2);
		equipoPokemon1.add(myPokemon3);
		
		equipoPokemon2.add(pokemonOponente1);
		equipoPokemon2.add(pokemonOponente2);
//		equipoPokemon2.add(pokemonOponente3);
		
		
		
		Trainer gabriel= new Trainer("Gabriel",equipoPokemon1);
		Trainer alejandro= new Trainer("Alejandro", equipoPokemon2);
		
		
		Battle batalla1 = new Battle(gabriel,alejandro);
		
		batalla1.trainer1VsTrainer2();

		
		
		
	}

}
