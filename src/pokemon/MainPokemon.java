package pokemon;

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
		
		Pokemon [] misPokemon={myPokemon1,myPokemon2,myPokemon3};
		Pokemon [] oponentesPokemon={pokemonOponente1,pokemonOponente2,pokemonOponente3};
		
		
		
		Trainer Gabriel= new Trainer("Gabriel", misPokemon);
		Trainer Alejandro= new Trainer("Alejandro", oponentesPokemon);
		
		
		Battle batalla1 = new Battle(Gabriel,Alejandro);
		
		batalla1.trainer1VsTrainer2();


	}

}
