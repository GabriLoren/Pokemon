package funcionalidades;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import crud.CargarMoves;
import crud.CargarTodosPokemons;
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
		
			sizeTodosLosPokemon = todosLosPokemon.size();
			
			numeroAleatorio = (int) (Math.random() * sizeTodosLosPokemon);
			
			pokemonEncontrado = todosLosPokemon.get(numeroAleatorio);
			
			//generamos el id a partir del último id de la tabla POKEMON_ENTRENADOR ya que po defecto el pokemon encontrado tiene el id del pokemon que hay
			//en la tabla pokemon donde están los pokemon por defecto
			int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");
			
			//añadimos un movimiento por defecto que tienen los pokemon cuando lo encontramos
			
//			pokemonEncontrado.getMoves().add(null);
			
			pokemonEncontrado.setId(idGenerado);
			
			//añade el movimeinto id 1 de la tabla moves por defecto
			pokemonEncontrado.getMoves().add(CargarMoves.cargarMovesEnPokemon(1));
			
		return pokemonEncontrado;

	}


	
	
}
