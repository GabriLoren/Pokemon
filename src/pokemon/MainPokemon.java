package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class MainPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Trainer gabriel=CargarEntrenador.cargarEntrenador("1");
		
		Trainer alejandro=CargarEntrenador.cargarEntrenador("2");
		
		CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(gabriel);
		
		CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(alejandro);
		
		
//		
//		Trainer alejandro=new Trainer(2, "Alejandro");
//		Trainer gabriel=new Trainer(2, "gabriel");
//		
//		Pokemon pokemon1= new Pokemon(4, null, 100);
//		
//		LinkedList<Pokemon>pokemonOponente= new LinkedList<Pokemon>();
//		
//		pokemonOponente.add(pokemon1);
//		
//
//		LinkedList<Pokemon>pokemonmios= new LinkedList<Pokemon>();
//		
//		pokemonmios.add(pokemon1);
//		pokemonmios.add(pokemon1);
//		pokemonmios.add(pokemon1);
//		
//		
//		alejandro.setEquipoPokemon(pokemonOponente);
//		gabriel.setEquipoPokemon(pokemonmios);
		
		Battle batalla1=new Battle(gabriel, alejandro);
		
		batalla1.trainer1VsTrainer2();


	}

}
