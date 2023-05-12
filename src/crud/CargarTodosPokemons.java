package crud;

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
	static int fertilidad=5;
	static String imagen;
	static String tipo1;
	static String tipo2;
	static String sonido;
	
	
	
	

//carga todos los pokemon que existen en la aplicacion
	public static  void cargarPokemonDesdeBbDd() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

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
				imagen= miRs.getString("imagen");
				tipo1=miRs.getString("tipo1");
				tipo2=miRs.getString("tipo2");
				sonido=miRs.getString("sonido");
//				if(miRs.getString("tipo2")!=null) {
//					tipo2=miRs.getString("tipo2");
//				}tipo2
				
				
				

				pokemon = new Pokemon(id, nombre, vida, ataque,defensa,ataqueSp,defensaSp,velocidad,stamina,nivel,fertilidad,imagen,Types.valueOf(tipo1),Types.valueOf(tipo2),sonido);
				pokemons.add(pokemon);
				
				System.out.println("tipo1 de pokemon "+pokemon.getType1());
				System.out.println("tipo2 de pokemon "+pokemon.getType2());
			}
			System.out.println("metodo cargarPokemonDesdeBbDd funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}

	



