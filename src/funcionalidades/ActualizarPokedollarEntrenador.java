package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pokemon;
import modelo.Trainer;

public class ActualizarPokedollarEntrenador {

	public static void actualizarPokedollarEntrenador(Trainer entrenador) {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentencia = "UPDATE ENTRENADOR SET POKEDOLLAR=? WHERE ID=?";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, entrenador.getPokeDollar());
			miPSt.setLong(2, entrenador.getId());

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
