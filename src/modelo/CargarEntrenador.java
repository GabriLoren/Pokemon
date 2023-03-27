package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CargarEntrenador {

	public static Trainer entrenador;
	

	public static Trainer cargarEntrenador(String id_entrenador) {
		

		Pokemon pokemon1;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM ENTRENADOR where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// cargo el pokemon1
			miPSt.setString(1, id_entrenador);
			ResultSet miRs = miPSt.executeQuery();

			String nombre = "";
			int id = 0;

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);

			}
//doy valores a los atributos del pokemon1 obteniendolos de la bbdd
			entrenador = new Trainer(id, nombre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entrenador;
	}
}
