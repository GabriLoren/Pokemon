package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;



public class Trainer {

	private int id;
	private String name;
	private LinkedList<Pokemon> todosLosPokemon;
	private LinkedList<Pokemon> equipoPokemon;

	public Trainer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.todosLosPokemon = new LinkedList<Pokemon>();
		this.equipoPokemon = new LinkedList<Pokemon>();
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LinkedList<Pokemon> getTodosLosPokemon() {
		return todosLosPokemon;
	}



	public void setTodosLosPokemon(LinkedList<Pokemon> todosLosPokemon) {
		this.todosLosPokemon = todosLosPokemon;
	}







	
//	public String equipoToString() {
//		return equipoPokemon[0].toString() +"\n"+equipoPokemon[1].toString()+"\n"+equipoPokemon[2].toString()+"\n"+equipoPokemon[3].toString();
//	}



	public LinkedList<Pokemon> getEquipoPokemon() {
		return equipoPokemon;
	}



	public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
		this.equipoPokemon = equipoPokemon;
	}



	public void cargarPokemonEnEntrenador() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT ID, NOMBRE_POKEMON FROM POKEMON_ENTRENADOR WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamenre
			miPSt.setLong(1, id);
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			String nombre = "";

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);

				Pokemon pokemon = new Pokemon(id, nombre);

				todosLosPokemon.add(pokemon);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon,String mote) {
		int idGenerado = generaID();
		
		//nombre del pokemon encontrado previamente
		String nombre=pokemon.getName();

		try {
			// 1.Crear conexion
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			// 2.crear statement
//				Statement miSt = miCon.createStatement();

			// 2.crear prepareStatemen
			String inSQL = "INSERT INTO POKEMON_ENTRENADOR (ID,MOTE,NOMBRE_POKEMON,ID_MOVIMIENTO1,ID_ENTRENADOR)"
					+ " VALUES (?,?,?,?,?)";
//				
			PreparedStatement miPSt = miCon.prepareStatement(inSQL);

			miPSt.setLong(1, idGenerado);// id
			miPSt.setString(2, mote);// MOTE
			miPSt.setString(3, nombre);// nombre
			miPSt.setString(4, "1");// movimiento1
			miPSt.setLong(5, this.id);// id_entrenador que está actualmemnte jugando

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// genera un id que no esté en la tabla pokemon_entrenador
	public static int generaID() {

		int id = 0;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM POKEMON_ENTRENADOR";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
			}

			miRs.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id + 1;
	}
	
	public static void insertaMote() {
		
		
		
	}
}
