package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import funcionalidades.GenerarID;
import modelo.Obj;
import modelo.Pokemon;
import modelo.Trainer;

public class AddObject {
	// muestra los objetos que tiene en la mochila el jugador
//	public static String obtenerObjetosBbDD() {
//		String todosObjetos = " ";
//		LinkedList<String> objetos = new LinkedList<String>();
//		String todosObjet = " ";
//
//		try {
//
//			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
//
//			String sentecia = "SELECT NOMBRE FROM OBJECT";
//			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
//
//			ResultSet miRs = miPSt.executeQuery();
//
//			while (miRs.next()) {
//
//				todosObjetos += (miRs.getString(1) + "\n ");
//
//			}
//
//			miRs.close();
//			miCon.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return todosObjetos;
//
//	}
//
//	public static void addObjectToPokemon(Obj objeto, Pokemon pokemon) {
//
//		pokemon.setObject(objeto);
//	}

//	
//	public static String mostraObjetosEntrenador(LinkedList<Obj>objetos) {
//		String objetosEntrenador = "";
//		if (objetos.size() > 0) {
//
//			for (int i = 0; i < objetos.size(); i++) {
//
//				objetosEntrenador += objetos.get(i).getName() + "\n";
//			}
//
//		}
//
//		return objetosEntrenador;
//
//	}
	/**
	 * inserta en la Linkedlist<Obj>objetos todos los objetos que posee el
	 * entrenador y se encuentran en la tabla objeto_entrenador
	 */

	public static void cargarObjetosEnEntrenador(Trainer entrenador) {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentecia = "SELECT o.*, oe.cantidad FROM OBJETO_ENTRENADOR oe join objecto o on o.id=oe.id_objeto WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamenre
			miPSt.setLong(1, entrenador.getId());
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			String nombre = "";
			int precio = 0;
			double ataque = 0;
			double defensa = 0;
			double defensaSp = 0;
			double ataqueSp = 0;
			double velocidad = 0;
			double estamina = 0;
			int cantidad=0;

			while (miRs.next()) {

				id = miRs.getInt(1);
				nombre = miRs.getString(2);
				precio = miRs.getInt(3);
				ataque = miRs.getDouble("ataque");
				defensa = miRs.getDouble("defensa");
				defensaSp = miRs.getDouble("defensa_sp");
				ataqueSp = miRs.getDouble("ataque_sp");
				velocidad = miRs.getDouble("velocidad");
				estamina = miRs.getDouble("estamina");
				cantidad= miRs.getInt("cantidad");
				
				Obj objeto = new Obj(id, nombre, precio, ataque, defensa, defensaSp,ataqueSp, velocidad, estamina,cantidad);

				entrenador.getObjetos().add(objeto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//inserta en la BbDD el objeto que compra el entrenador
	public static void insertarEnBbDdElObjetoComprado(Obj objeto, Trainer entrenador) {
//		int idGenerado = GenerarID.generaID("SELECT ID FROM OBJETO_ENTRENADOR");

		int cantidad = objtenerCantidadDeObjetos(entrenador, objeto);

		
		//si el tipo de objeto aun no lo tiene se inserta por primera vez en la bbdd
		if (cantidad == 0) {

			try {

				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

				String sentencia = "INSERT INTO OBJETO_ENTRENADOR (ID_OBJETO,ID_ENTRENADOR, CANTIDAD)"
						+ " VALUES (?,?,?)";

				PreparedStatement miPSt = miCon.prepareStatement(sentencia);

				miPSt.setLong(1, objeto.getId());// id del objeto en la tabla objeto
				miPSt.setLong(2, entrenador.getId());// id_entrenador que está actualmemnte jugando
				miPSt.setLong(3, 1);//

				miPSt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			//si ya tiene el tipo de objeto que ha comprado solo debe actualizarse la cantidad
			try {

				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

				String sentencia = "UPDATE OBJETO_ENTRENADOR SET CANTIDAD=? WHERE ID_OBJETO=? AND ID_ENTRENADOR=?";

				PreparedStatement miPSt = miCon.prepareStatement(sentencia);

				miPSt.setLong(1, cantidad + 1);
				miPSt.setLong(2, objeto.getId());// id del objeto en la tabla objeto
				miPSt.setLong(3, entrenador.getId());// id_entrenador que está actualmemnte jugando

				miPSt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void eliminaEnBbDdElObjetoSacadoDeLaMochila(Obj objeto, Trainer entrenador) {


		int cantidad = objtenerCantidadDeObjetos(entrenador, objeto);

		if (cantidad == 1) {

			try {

				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

				String sentencia = "DELETE FROM OBJETO_ENTRENADOR WHERE ID_OBJETO=? AND ID_ENTRENADOR=?";

				PreparedStatement miPSt = miCon.prepareStatement(sentencia);

				miPSt.setLong(1, objeto.getId());// id del objeto en la tabla objeto
				miPSt.setLong(2, entrenador.getId());// id_entrenador que está actualmemnte jugando
				

				miPSt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			try {

				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

				String sentencia = "UPDATE OBJETO_ENTRENADOR SET CANTIDAD=? WHERE ID_OBJETO=? AND ID_ENTRENADOR=?";

				PreparedStatement miPSt = miCon.prepareStatement(sentencia);

				miPSt.setLong(1, cantidad - 1);
				miPSt.setLong(2, objeto.getId());// id del objeto en la tabla objeto
				miPSt.setLong(3, entrenador.getId());// id_entrenador que está actualmemnte jugando

				miPSt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

//	public static void eliminaEnBbDdElObjetoInsertadoEnPokemon(Obj objeto) {
//
//		try {
//
//			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");
//
//			String sentencia = "DELETE FROM OBJETO_ENTRENADOR WHERE ID=?";
//
//			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
//			miPSt.setLong(1, objeto.getId());// id en la tabla objeto_entrenador
//
//			miPSt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

	public static int objtenerCantidadDeObjetos(Trainer entrenador, Obj objeto) {

		int cantidad = 0;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentecia = "SELECT CANTIDAD FROM OBJETO_ENTRENADOR WHERE ID_OBJETO=? AND ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			miPSt.setLong(1, objeto.getId());
			miPSt.setLong(2, entrenador.getId());

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				cantidad = miRs.getInt("cantidad");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cantidad;

	}

}
