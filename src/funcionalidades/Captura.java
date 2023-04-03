package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pokemon;

public class Captura {

	public static void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon, String mote, int idEntrenador) {
		int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");

		// nombre del pokemon encontrado previamente
		String nombre = pokemon.getName();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentencia = "INSERT INTO POKEMON_ENTRENADOR (ID,MOTE,NOMBRE_POKEMON,ID_MOVIMIENTO1,ID_ENTRENADOR)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, idGenerado);// id
			miPSt.setString(2, mote);// MOTE
			miPSt.setString(3, nombre);// nombre
			miPSt.setString(4, "1");// movimiento1
			miPSt.setLong(5, idEntrenador);// id_entrenador que está actualmemnte jugando

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
