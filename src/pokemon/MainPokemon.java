package pokemon;

import java.util.LinkedList;

public class MainPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Obj obj = new Obj(1, "piedra", 0, 1.5, 0, 0, 0);

		Move move1 = new Move(1, Category.ATK, 10, Types.NORMAL, " ", 0, 0);

		Move move2 = new Move(1, Category.ATK, 20, Types.NORMAL, " ", 0, 0);

		Pokemon myPokemon1 = new Pokemon(move1);
		Pokemon myPokemon2 = new Pokemon(move1);
		Pokemon myPokemon3 = new Pokemon(move1);
		
		Pokemon pokemonOponente1 = new Pokemon(move2);
		Pokemon pokemonOponente2 = new Pokemon(move2);
		Pokemon pokemonOponente3 = new Pokemon(move2);
		
		LinkedList<Pokemon> equipoPokemon1= new LinkedList<Pokemon>();
		LinkedList<Pokemon> equipoPokemon2= new LinkedList<Pokemon>();
		
		equipoPokemon1.add(myPokemon1);
		equipoPokemon1.add(myPokemon2);
		equipoPokemon1.add(myPokemon3);
		
		equipoPokemon2.add(pokemonOponente1);
		equipoPokemon2.add(pokemonOponente2);
		equipoPokemon2.add(pokemonOponente3);
		
		
		
		Trainer Gabriel= new Trainer("Gabriel",equipoPokemon1);
		Trainer Alejandro= new Trainer("Alejandro", equipoPokemon2);
		
		
		Battle batalla1 = new Battle(Gabriel,Alejandro);
		
		batalla1.trainer1VsTrainer2();


	}

}
