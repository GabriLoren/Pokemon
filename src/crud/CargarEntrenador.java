package crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

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
	
	public static void setEntrenador(Trainer entrenador) {
		CargarEntrenador.entrenador = entrenador;
	}

	// comprueba si el usuario existe y si es así lo carga en el programa
	public static boolean comprobarUsuarioYCargarlo(String nombreUsuario) {

		boolean usuarioExiste = false;

		System.out.println(todosLosEntrenadores.size());

		for (int i = 0; i < todosLosEntrenadores.size(); i++) {

			if (nombreUsuario.equalsIgnoreCase(todosLosEntrenadores.get(i).getName())) {

				entrenador = todosLosEntrenadores.get(i);

				// sacamos de la lista de todos los entrenadores que tenemos, el entrenador que
				// va a iniciar la partida
				// para que al seleccionar uno aleatorio en la batalla no coincida con el
				// que tenemos en ese momento en juego
				CargarTodosLosEntrenadores.getTodosLosEntrenadores().remove(todosLosEntrenadores.get(i));

				usuarioExiste = true;
				break;

			}

		}

		return usuarioExiste;

	}

	/**
	 * Devuelve un Tainer aleatorio de los que se han cargado al inicio del juego
	 * distinto del Trainer del usuario
	 * 
	 * @return Trainer
	 */
	public static Trainer obtenerEntrenadorAleatorio() {

		Trainer entrenadorJugador = CargarEntrenador.getEntrenador();

		LinkedList<Trainer> entrenadores = CargarTodosLosEntrenadores.getTodosLosEntrenadores();

		Trainer entrenadorContrincante;

		// podriamos controlar esta excepcion si nos da timepo a acabar la aplicación
		int posicionEntrenador = -1;

		do {

			posicionEntrenador = (int) (Math.random() * entrenadores.size());
		} while (entrenadorJugador.getId() == entrenadores.get(posicionEntrenador).getId());

		entrenadorContrincante = entrenadores.get(posicionEntrenador);

		return entrenadorContrincante;

	}

}
