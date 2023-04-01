package modelo;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import cargar.CargarPokemons;

public class GeneraPokemonAleatorio {

	static LinkedList<Pokemon> todosLosPokemon;
	static int sizeTodosLosPokemon;
	static int numeroAleatorio;
	static Pokemon pokemonEncontrado;

//	Devuelve un pokemon aleatorio de todos los que existen
	public static Pokemon mostrarPokemonEncontrado()  {
//accedo a la linkedlist de los pokemons que previamente se han cargado y entre ellos elijo uno al azar

		try {
			todosLosPokemon = CargarPokemons.getPokemon();
//			
			sizeTodosLosPokemon = todosLosPokemon.size();
			numeroAleatorio = (int) (Math.random() * sizeTodosLosPokemon);
			
			pokemonEncontrado = todosLosPokemon.get(numeroAleatorio);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no se encontro pokemon, intenrtalo de nuevo");
			
		}
		return pokemonEncontrado;

	}

//	public static void insertarEnBbDd()  {
//
//			
//			try {
//				// 1.Crear conexion
//				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
//
//				// 2.crear statement
////				Statement miSt = miCon.createStatement();
//
//				// 2.crear prepareStatemen
//				String inSQL = "INSERT INTO POKEMON_ENTRENADOR (ID,NOMBRE_POKEMON,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4,ID_ENTRENADOR)"
//						+ " VALUES (?,?,?,?,?,?,?)";
////				
//				PreparedStatement miPSt = miCon.prepareStatement(inSQL);
//				
//				miPSt.setLong(1, generaID());//id
//				//id_entrenador que está actualmemnte jugando
//				miPSt.setString(2, pokemon.getName());// nombre
//				miPSt.setString(3, "1");// movimiento1
//				miPSt.setString(4, "2");// movimiento2
//				miPSt.setString(5, "3");// movimiento3
//				miPSt.setString(6, "1");// movimiento4
//				miPSt.setLong(7, entrenador.getId());// id_entrenador
//
//
//				miPSt.executeUpdate();
//
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//	
	
	
	
}
