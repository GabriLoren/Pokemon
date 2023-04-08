package funcionalidades;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;


import cargar.CargarTodosPokemons;
import modelo.Pokemon;

public class GeneraPokemonAleatorio {

	static LinkedList<Pokemon> todosLosPokemon;
	static int sizeTodosLosPokemon;
	static int numeroAleatorio;
	static Pokemon pokemonEncontrado;

//	Devuelve un pokemon aleatorio de todos los que existen
	public static Pokemon mostrarPokemonEncontrado()  {
//accedo a la linkedlist de los pokemons que previamente se han cargado y entre ellos elijo uno al azar


			todosLosPokemon = CargarTodosPokemons.getPokemon();
			
			System.out.println(todosLosPokemon.size());
		
			sizeTodosLosPokemon = todosLosPokemon.size();
			numeroAleatorio = (int) (Math.random() * sizeTodosLosPokemon);
			
			pokemonEncontrado = todosLosPokemon.get(numeroAleatorio);
			
		return pokemonEncontrado;

	}


	
	
}
