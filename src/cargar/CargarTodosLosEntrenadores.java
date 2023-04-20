package cargar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import funcionalidades.AddObject;
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
				
				
				
				
						//inserta en cada entrenador todos sus pokemon tanto en el equipo como en la caja (no están en elequipo)
						CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(entrenador);
						
						
						
						System.out.println("Cargamos el entrenador con sus pokemon "+entrenador.toString());
						System.out.println();

						
						AddObject.cargarObjetosEnEntrenador(entrenador);

				TodosLosEntrenadores.add(entrenador);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(TodosLosEntrenadores.toString());

	}

}
