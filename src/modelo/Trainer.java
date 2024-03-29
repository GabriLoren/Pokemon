package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import crud.CargarMoves;
import crud.CargarTodosLosObjetos;
import crud.PokemonEntrenadorCrud;
import funcionalidades.GenerarID;

public class Trainer {

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", pokeDollar=" + pokeDollar + ", todosLosPokemon="
				+ todosLosPokemon + ", equipoPokemon=" + equipoPokemon + ", objetos=" + objetos + "]";
	}

	private int id;
	private String name;
	private int pokeDollar;
	private LinkedList<Pokemon> todosLosPokemon;
	private LinkedList<Pokemon> equipoPokemon;
	private LinkedList<Obj> objetos;

	public Trainer(int id, String name, int pokeDollar) {
		super();
		this.id = id;
		this.name = name;
		this.todosLosPokemon = new LinkedList<Pokemon>();
		this.equipoPokemon = new LinkedList<Pokemon>();
		this.objetos = new LinkedList<>();
		this.pokeDollar = pokeDollar;
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

//	public void comprobarSiTieneObjetoComprado(Obj objetoComprado) {
//		
//		boolean objetoRepetido=false;
//
//		for (int i = 0; i < this.objetos.size(); i++) {
//
//			if (objetos.get(i).getName().equalsIgnoreCase(objetoComprado.getName())) {
//
//				objetos.get(i).setCantidad(objetos.get(i).getCantidad() + 1);
//				
//				//si entra el objeto lo tiene repetido y por tanto solo
//				//hay que actualizar el número de objetos del mismo tipo
//				objetoRepetido=true;
//				break;
//
//			}
//
//			//si no lo tiene repetido lo inserta por primera vez en la lista de objetos
//			//del entrenador(mochila)
//			if(objetoRepetido==false) {
//				
//				objetoComprado.setCantidad(1);
//				this.objetos.add(objetoComprado);	
//			}
//			
//
//		}
//	}

	
	/**
	 * @param Pokemon pokemon
	 * 
	 * Inserta en la BbDd y en la lista todosLosPokemon el pokemon capturado
	 */
	public void capturar(Pokemon pokemon) {
		Random r = new Random();

		pokemon.setStatus("sinEstado");

		pokemon.setAtk(r.nextInt(10 - 1) + 1);

		pokemon.setDef(r.nextInt(10 - 1) + 1);

		pokemon.setSpAtk(r.nextInt(10 - 1) + 1);

		pokemon.setSpDef(r.nextInt(10 - 1) + 1);

		pokemon.setSpeed(r.nextInt(10 - 1) + 1);

		pokemon.setNickname(pokemon.getName());

		pokemon.setIdPokedex(pokemon.getId());

		if (pokemon.getEquipo().equals("SI")) {

			this.equipoPokemon.add(pokemon);
		}

		else {

			this.todosLosPokemon.add(pokemon);
		}

		// se le inserta el objeto por defecto que es lo mismo que no tener objeto
		pokemon.setObject(CargarTodosLosObjetos.getTodosLosObjetos().getFirst());
		
		PokemonEntrenadorCrud.insertarEnBbDdElPokemonEncontrado(pokemon, this);

	}

	/**
	 * @param Obj objeto
	 * 
	 * Inserta el objeto comprado en la colección de objetos del entrenador
	 */
	public void insertarObjetoComprado(Obj objeto) {

		this.objetos.add(objeto);
	}

//	public String mostraTodosLosPokemons() {
//		String pokemonsEntrenador = "";
//		if (todosLosPokemon.size() > 0) {
//
//			for (int i = 0; i < todosLosPokemon.size(); i++) {
//
//				pokemonsEntrenador += todosLosPokemon.get(i).getNickname() + "      " + todosLosPokemon.get(i).getName()
//						+ "\n";
//			}
//
//		}
//
//		pokemonsEntrenador = " MOTE      " + " RAZA\n" + "\n" + pokemonsEntrenador;
//
//		return pokemonsEntrenador;
//
//	}
//
//	// igual que el anterior pero static
//	public static String mostraTodosLosPokemonsStatic(LinkedList<Pokemon> todosLosPokemon) {
//		String pokemonsEntrenador = "";
//		if (todosLosPokemon.size() > 0) {
//
//			for (int i = 0; i < todosLosPokemon.size(); i++) {
//
//				pokemonsEntrenador += todosLosPokemon.get(i).getNickname() + "      " + todosLosPokemon.get(i).getName()
//						+ "\n";
//			}
//
//		}
//
//		pokemonsEntrenador = " MOTE      " + " RAZA\n" + "\n" + pokemonsEntrenador;
//
//		return pokemonsEntrenador;
//
//	}

}
