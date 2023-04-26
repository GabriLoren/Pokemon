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

	// comprueba si el usuario existe y si es así lo carga en el programa
	public static boolean comprobarUsuarioYCargarlo(String nombreUsuario) {

		boolean usuarioExiste = false;

		System.out.println(todosLosEntrenadores.size());

		for (int i = 0; i < todosLosEntrenadores.size(); i++) {

			if (nombreUsuario.equalsIgnoreCase(todosLosEntrenadores.get(i).getName())) {

				entrenador = todosLosEntrenadores.get(i);

				// sacamos de la lista de todos los entrenadores que tenemos el entrenador que
				// va a iniciar la partida
				// para que cuando sellecionemos uno aleatorio en la batalla no se encuentre el
				// que tenemos en ese momento en juego
				CargarTodosLosEntrenadores.getTodosLosEntrenadores().remove(todosLosEntrenadores.get(i));

				usuarioExiste = true;
				break;

			}

		}

		return usuarioExiste;

	}

	// devuelve un entrenador aleatorio de la lista que se le pasa por parámetro
	public static Trainer obtenerEntrenadorAleatorio(LinkedList<Trainer> entrenadores) {

		Trainer entrenadorContrincante = null;

		int posicionEntrenador = (int) (Math.random() * entrenadores.size());

		entrenadorContrincante = entrenadores.get(posicionEntrenador);

		return entrenadorContrincante;

	}

}