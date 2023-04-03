package cargar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import funcionalidades.AddObject;
import funcionalidades.ComprobarUsuarioExiste;
import modelo.Pokemon;
import modelo.Trainer;

public class CargarEntrenador {

	private static Trainer entrenador;
	private static String nombre = "";
	private static int id = 0;

	public static Trainer getEntrenador() {
		return entrenador;
	}

//	public static void cargarEntrenador(String nombreEntrenador) {

//		IOException mia = new IOException();
//
//		if (ComprobarUsuarioExiste.ComprobarUsuarioExiste(nombreEntrenador))
//
//			try {
//
//				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
//
//				String sentecia = "SELECT * FROM ENTRENADOR WHERE NOMBRE=?";
//				PreparedStatement miPSt = miCon.prepareStatement(sentecia);
//				miPSt.setString(1, nombreEntrenador);
//				ResultSet miRs = miPSt.executeQuery();
//
//				while (miRs.next()) {
//
//					id = Integer.parseInt(miRs.getString(1));
//					System.out.println(id);
//					nombre = miRs.getString(2);
//					System.out.println(nombre);
//
//				}
//
//				entrenador = new Trainer(id, nombre);
//
//				entrenador.cargarPokemonEnEntrenador();
//				
//				entrenador.cargarObjetosEnEntrenador();
//
//				System.out.println("metodo cargar entrenador correcto");
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//	}
//comprueba si el usuario existe y si es así lo carga en el programa
	public static boolean comprobarUsuarioYCargarlo(String nombreUsuario) throws SQLException {

		boolean usuarioExiste = false;

		

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			Statement miSt = miCon.createStatement();
			ResultSet miRs = miSt.executeQuery("SELECT * FROM ENTRENADOR");
			
			while (miRs.next()) {
				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);

				if (nombre.equalsIgnoreCase(nombreUsuario)) {
					
					entrenador = new Trainer(id, nombre);
					
					CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(id);
					
					AddObject.cargarObjetosEnEntrenador(id, entrenador.getObjetos());
					

					System.out.println("carga completa");
					
					usuarioExiste = true;
					break;
				}
			}
			

//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//
//		}

		return usuarioExiste;

	}

}
