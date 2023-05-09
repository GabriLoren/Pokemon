package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import crud.CargarMoves;
import modelo.Obj;
import modelo.Pokemon;
import modelo.Trainer;

public class AddObject {
	// muestra los objetos que tiene en la mochila el jugador
	public static String obtenerObjetosBbDD() {
		String todosObjetos = " ";
		LinkedList<String> objetos = new LinkedList<String>();
		String todosObjet = " ";

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT NOMBRE FROM OBJECT";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				todosObjetos += (miRs.getString(1) + "\n ");

			}

			miRs.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todosObjetos;

	}

	public static void addObjectToPokemon(Obj objeto, Pokemon pokemon) {

		pokemon.setObject(objeto);
	}

	
		
		
		
	
	public static String mostraObjetosEntrenador(LinkedList<Obj>objetos) {
		String objetosEntrenador = "";
		if (objetos.size() > 0) {

			for (int i = 0; i < objetos.size(); i++) {

				objetosEntrenador += objetos.get(i).getName() + "\n";
			}

		}

		return objetosEntrenador;

	}
	/**
	 * inserta en la Linkedlist<Obj>objetos todos los objetos que posee el entrenador y se encuentran en la tabla objeto_entrenador
	 */

	public static void cargarObjetosEnEntrenador(Trainer entrenador) {
		
		

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM OBJETO_ENTRENADOR WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamenre
			miPSt.setLong(1, entrenador.getId());
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			String nombre = "";

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);

				Obj objeto = new Obj(id, nombre);

				entrenador.getObjetos().add(objeto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertarEnBbDdElObjetoComprado(Obj objeto, int idEntrenador) {
		int idGenerado = GenerarID.generaID("SELECT ID FROM OBJETO_ENTRENADOR");

		// nombre del OBJETO COMPRADO previamente
		String nombre = objeto.getName();
		int idObjeto = objeto.getId();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentencia = "INSERT INTO OBJETO_ENTRENADOR (ID,NOMBRE,ID_OBJETO,ID_ENTRENADOR)"
					+ " VALUES (?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, idGenerado);// id en la tabla objeto_entrenador
			miPSt.setString(2, nombre);// nombre del objeto
			miPSt.setLong(3, idObjeto);// id del objeto en la tabla objeto
			miPSt.setLong(4, idEntrenador);// id_entrenador que está actualmemnte jugando

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
