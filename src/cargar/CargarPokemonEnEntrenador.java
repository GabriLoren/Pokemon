package cargar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.Pokemon;

public class CargarPokemonEnEntrenador {
	
	private static LinkedList<Pokemon>todosLosPokemon=new LinkedList<>();

	
	public static void cargarPokemonEnEntrenador(int idEntrenador) {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT MOTE, NOMBRE_POKEMON FROM POKEMON_ENTRENADOR WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamenre
			miPSt.setLong(1, idEntrenador);
			ResultSet miRs = miPSt.executeQuery();

			String mote = "";
			String nombre = "";

			while (miRs.next()) {

				mote = miRs.getString(1);
				nombre = miRs.getString(2);

				Pokemon pokemon = new Pokemon(nombre, mote);

				todosLosPokemon.add(pokemon);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
