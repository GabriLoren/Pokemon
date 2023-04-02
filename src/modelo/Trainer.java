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
	private LinkedList<Object>objetos;

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

	public void insertraPokemonCapturado(Pokemon pokemon) {

		this.todosLosPokemon.add(pokemon);
	}
	
	public void insertarObjetoComprado(Obj objeto) {

		this.objetos.add(objeto);
	}

	public void cargarPokemonEnEntrenador() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT MOTE, NOMBRE_POKEMON FROM POKEMON_ENTRENADOR WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamenre
			miPSt.setLong(1, id);
			ResultSet miRs = miPSt.executeQuery();

			String mote = "";
			String nombre = "";

			while (miRs.next()) {

				mote = miRs.getString(1);
				nombre = miRs.getString(2);

				Pokemon pokemon = new Pokemon(nombre, mote);

				todosLosPokemon.add(pokemon);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon, String mote) {
		int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");

		// nombre del pokemon encontrado previamente
		String nombre = pokemon.getName();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentencia = "INSERT INTO POKEMON_ENTRENADOR (ID,MOTE,NOMBRE_POKEMON,ID_MOVIMIENTO1,ID_ENTRENADOR)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
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

	
}
