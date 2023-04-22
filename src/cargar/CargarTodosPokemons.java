package cargar;

import java.sql.*;

import java.util.LinkedList;

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
	static int ataque;
	static int defensa;
	static int ataqueSp;
	static int defensaSp;
	static int velocidad;
	static int stamina;
	static int nivel;
	static int fertilidad;
	
	
	

//carga todos los pokemon que existen en la aplicacion
	public static  void cargarPokemonDesdeBbDd() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM POKEMON");

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				vida = Integer.parseInt(miRs.getString(3));
				ataque = Integer.parseInt(miRs.getString(4));
				defensa = Integer.parseInt(miRs.getString(5));
				ataqueSp = Integer.parseInt(miRs.getString(6));
				defensaSp = Integer.parseInt(miRs.getString(7));
				velocidad = Integer.parseInt(miRs.getString(8));
				stamina = Integer.parseInt(miRs.getString(9));
				nivel = Integer.parseInt(miRs.getString(10));
				fertilidad=miRs.getInt("fertilidad");

				pokemon = new Pokemon(id, nombre, vida, ataque,defensa,ataqueSp,defensaSp,velocidad,stamina,nivel,fertilidad);
				pokemons.add(pokemon);
			}
			System.out.println("metodo cargarPokemonDesdeBbDd funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}

	


