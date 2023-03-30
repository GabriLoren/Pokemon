package cargar;

import java.sql.*;
import java.util.LinkedList;

import modelo.Category;
import modelo.Move;
import modelo.Pokemon;
import modelo.Types;

public class CargarPokemon { 

	private static LinkedList<Pokemon> pokemon = new LinkedList<>();
	
	public static LinkedList<Pokemon> getPokemon() {
		return pokemon;
	}

	static Pokemon pokemon1;
	static int id;
	static String nombre;
	static int vida;

	public static  LinkedList<Pokemon> cargarPokemonDesdeBbDd() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM POKEMON");

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				vida = Integer.parseInt(miRs.getString(1));

				pokemon1 = new Pokemon(id, nombre, vida);
				pokemon.add(pokemon1);
			}
			System.out.println("La carga ha sido satisfactoria");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemon;


	}

}
