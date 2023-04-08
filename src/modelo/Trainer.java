package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

import cargar.CargarPokemonEnEntrenador;
import funcionalidades.GenerarID;

public class Trainer {

	private int id;
	private String name;
	private int pokeDollar;
	private LinkedList<Pokemon> todosLosPokemon;
	private LinkedList<Pokemon> equipoPokemon;
	private LinkedList<Obj> objetos;
	

	public Trainer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.todosLosPokemon = new LinkedList<Pokemon>();
		this.equipoPokemon = new LinkedList<Pokemon>();
		this.objetos = new LinkedList<>();
		this.pokeDollar=1000;
	}
	
	

	public int getPokeDollar() {
		return pokeDollar;
	}



	public void setPokeDollar(int pokeDollar) {
		this.pokeDollar = pokeDollar;
	}



	public LinkedList<Obj> getObjetos() {
		return objetos;
	}

	public void setObjetos(LinkedList<Obj> objetos) {
		this.objetos = objetos;
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

	public LinkedList<Pokemon> getEquipoPokemon() {
		return equipoPokemon;
	}

	public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
		this.equipoPokemon = equipoPokemon;
	}

	public void insertraPokemonCapturado(Pokemon pokemon, String mote) {

		pokemon.setNickname(mote);

		this.todosLosPokemon.add(pokemon);
	}

	public void insertarObjetoComprado(Obj objeto) {

		this.objetos.add(objeto);
	}

	public String mostraTodosLosPokemons() {
		String pokemonsEntrenador = "";
		if (todosLosPokemon.size() > 0) {

			for (int i = 0; i < todosLosPokemon.size(); i++) {

				pokemonsEntrenador += todosLosPokemon.get(i).getNickname() + "      " + todosLosPokemon.get(i).getName()
						+ "\n";
			}

		}

		pokemonsEntrenador = " MOTE      " + " RAZA\n" + "\n" + pokemonsEntrenador;

		return pokemonsEntrenador;

	}

}
