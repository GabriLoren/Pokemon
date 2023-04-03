package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import cargar.CargarMoves;
import modelo.Obj;
import modelo.Pokemon;

public class AddObject {
	// muestra los objetos que tiene en la mochila el jugador
	public static String obtenerObjetosBbDD() {
		String todosObjetos=" ";
		LinkedList<String> objetos = new LinkedList<String>();
		String todosObjet=" ";

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT NOMBRE FROM OBJECT";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				todosObjetos+=(miRs.getString(1)+"\n ");

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

	
	
	
	public  void obtenerObjetoSeleccionado(String nombreObjeto) {
		
		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM OBJECT WHERE NOMBRE=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
			miPSt.setString(1, nombreObjeto); 
			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				(miRs.getString(1));

			}
			

			
		
		

			miRs.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
}
