package cargar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import modelo.Trainer;

public class CargarTodosLosEntrenadores {

	private static LinkedList<Trainer> TodosLosEntrenadores=new LinkedList<Trainer>();



	public static LinkedList<Trainer> getTodosLosEntrenadores() {
		return TodosLosEntrenadores;
	}



	public static void cargarTodosLosEntrenadores() {

	

		Connection miCon;
		try {
			miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();
			ResultSet miRs = miSt.executeQuery("SELECT * FROM ENTRENADOR");

			Trainer entrenador;
			String nombre = "";
			int id = 0;
			int pokedollar=0;

			while (miRs.next()) {
				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				pokedollar=Integer.parseInt(miRs.getString(3));

				entrenador = new Trainer(id, nombre, pokedollar);
				
				
						//inserta en cada entrnador todos sus pokemon
						entrenador.setTodosLosPokemon(CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(id));

//						AddObject.cargarObjetosEnEntrenador(id, entrenador.getObjetos());

				TodosLosEntrenadores.add(entrenador);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(TodosLosEntrenadores.toString());

	}

}
