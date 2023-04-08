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
	private static LinkedList<Trainer> todosLosEntrenadores = CargarTodosLosEntrenadores.getTodosLosEntrenadores();
	
	

public static Trainer getEntrenador() {
		return entrenador;
	}



	//comprueba si el usuario existe y si es así lo carga en el programa
	public static boolean comprobarUsuarioYCargarlo(String nombreUsuario) {

		boolean usuarioExiste = false;

		for (int i = 0; i < todosLosEntrenadores.size(); i++) {

			if (nombreUsuario.equalsIgnoreCase(todosLosEntrenadores.get(i).getName())) {

				entrenador = todosLosEntrenadores.get(i);
				usuarioExiste = true;
				break;

			}

		}
		System.out.println(entrenador.toString());
		return usuarioExiste;
	}
}
