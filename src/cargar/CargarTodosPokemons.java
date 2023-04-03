package cargar;

import java.sql.*;
import java.util.LinkedList;

import modelo.Category;
import modelo.Move;
import modelo.Pokemon;
import modelo.Types;

public class CargarTodosPokemons {

	private static LinkedList<Pokemon> pokemons = new LinkedList<>();

	public static LinkedList<Pokemon> getPokemon() {
		return pokemons;
	}

	static Pokemon pokemon;
	static int id;
	static String nombre;
	static int vida;

//carga todos los pokemon que existen en la aplicacion
	public static  void cargarPokemonDesdeBbDd() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM POKEMON");

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				vida = Integer.parseInt(miRs.getString(1));

				pokemon = new Pokemon(id, nombre, vida);
				pokemons.add(pokemon);
			}
			System.out.println("metodo cargarPokemonDesdeBbDd funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}

	



