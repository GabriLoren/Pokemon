package cargar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.Pokemon;
import modelo.Trainer;

public class CargarEntrenador {

	private static Trainer entrenador;
	private static String nombre = "";
	private static int id = 0;

	public static String cargarEntrenador(String numero) {
		

		Pokemon pokemon1;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM ENTRENADOR where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// cargo el pokemon1
			miPSt.setString(1, numero);
			ResultSet miRs = miPSt.executeQuery();

			

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);

			}
//doy valores a los atributos del pokemon1 obteniendolos de la bbdd
			entrenador = new Trainer(id, nombre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entrenador.getName();
	}
}
