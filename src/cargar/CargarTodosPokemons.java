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
	static int stamina=100;
	static int nivel;
	static int fertilidad=5;
	static String imagen;
	String type1 = "";
	String type2 = "";

	
	
	

//carga todos los pokemon que existen en la aplicacion
	public static  void cargarPokemonDesdeBbDd() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM POKEMON");

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString("pokedex_num"));
				nombre = miRs.getString("name");
				vida = Integer.parseInt(miRs.getString("base_vit"));
				ataque = Integer.parseInt(miRs.getString("base_atk"));
				defensa = Integer.parseInt(miRs.getString("base_def"));
				ataqueSp = Integer.parseInt(miRs.getString("base_satk"));
				defensaSp = Integer.parseInt(miRs.getString("base_sdef"));
				velocidad = Integer.parseInt(miRs.getString("base_spd"));
				nivel = Integer.parseInt(miRs.getString("base_lvl"));
				imagen= miRs.getString("imagen");
				type1 = miRs.getString("type1");
				type2 = miRs.getString("type2");

				Pokemon pokemon = new Pokemon( id,  nombre,  Types.valueOf(type1),  Types.valueOf(type2),  vitality, ataque, defensa, ataqueSp,
						defensaSp, velocidad, stamina, nivel, equipo, exp,  imagen, fertilidad);
				pokemons.add(pokemon);
			}
			System.out.println("metodo cargarPokemonDesdeBbDd funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}

	



