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
	

	public static Trainer getEntrenador() {
		return entrenador;
	}


	public static void cargarEntrenador(String nombre) {

		

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM ENTRENADOR WHERE NOMBRE=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
			miPSt.setString(1, nombre);
			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				System.out.println(id);
				nombre = miRs.getString(2);
				System.out.println(nombre);

			}

			entrenador = new Trainer(id, nombre);
			
			entrenador.cargarPokemonEnEntrenador();
			
			System.out.println("carga completa");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		

	}
}
