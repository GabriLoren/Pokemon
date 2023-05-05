package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import funcionalidades.GenerarID;
import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;

public class PokemonEntrenadorCrud {
	
//	public static void captura(Pokemon pokemon, int idEntrenador) {
//		
////		pokemon.setNickname(mote);
//		
//		insertarEnBbDdElPokemonEncontrado(pokemon, idEntrenador);
//		
//	}

	public static void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon, int idEntrenador) {
		int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");

		// nombre del pokemon encontrado previamente
//		String nombre = pokemon.getName();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentencia = "INSERT INTO POKEMON_ENTRENADOR (ID,NOMBRE,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,STAMINA,NIVEL,"
					+ "FERTILIDAD,EQUIPO,IMAGEN,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, idGenerado);// id
			miPSt.setString(2, pokemon.getName());// nombre 
			miPSt.setString(3, pokemon.getName());// el mote por defecto es el ombre del pokemon
			miPSt.setLong(4, idEntrenador);// id_entrenador que está actualmemnte jugando
			miPSt.setLong(5, pokemon.getVit());
			miPSt.setLong(6, pokemon.getAtk());
			miPSt.setLong(7, pokemon.getDef());
			miPSt.setLong(8, pokemon.getSpAtk());
			miPSt.setLong(9, pokemon.getSpDef());
			miPSt.setLong(10, pokemon.getSpeed());
			miPSt.setLong(11, pokemon.getStamina());
			miPSt.setLong(12, pokemon.getLevel());
			miPSt.setLong(13, pokemon.getFertility());
			miPSt.setString(14, "NO");
			miPSt.setString(15, pokemon.getImagen());
			//AL CAPTURARLO TODOS TIENEN EL MISMO MOVIMIENTO POR AHORA, EL ID 1 DE LA TABLA MOVE
			miPSt.setLong(16, pokemon.getMoves().get(0).getId());
			//EL RESTO DE MOVES EL ID ES 0 QUE ES LO MISMO QUE NO HBER MOVIMIENTO
			miPSt.setLong(17, 0);
			miPSt.setLong(18, 0);
			miPSt.setLong(19, 0);
			
			

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void cargarPokemonEnEntrenador(Trainer entrenador) {

//		LinkedList<Pokemon> todosLosPokemon = new LinkedList<>();
//		LinkedList<Pokemon> equipoPokemon = new LinkedList<>();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM POKEMON_ENTRENADOR WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamente
			miPSt.setLong(1, entrenador.getId());
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			String nombre = "";
			String mote = "";
//			id_entrenador int
			int vida = 0;
			int ataque = 0;
			int defensa = 0;
			int ataqueSp = 0;
			int defensaSp = 0;
			int velocidad = 0;
			int stamina = 0;
			int nivel = 0;
			int fertilidad = 0;
			String equipo = "si";
			String estado = "SinEstado";
			String imagen = "";
			int id_movimiento1 = 0;
			int id_movimiento2=0;
			int id_movimiento3=0;
			int id_movimiento4=0;
//			id_objeto int);

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				mote = miRs.getString(3);
				vida = miRs.getInt(5);
				ataque = miRs.getInt(6);
				defensa = miRs.getInt(7);
				ataqueSp = miRs.getInt(8);
				defensaSp = miRs.getInt(9);
				velocidad = miRs.getInt(10);
				stamina = miRs.getInt(11);
				nivel = miRs.getInt(12);
				equipo = miRs.getString(18);
				id_movimiento1 = miRs.getInt("id_movimiento1");
				id_movimiento2 = miRs.getInt("id_movimiento2");
				id_movimiento3 = miRs.getInt("id_movimiento3");
				id_movimiento4 = miRs.getInt("id_movimiento4");
				fertilidad = miRs.getInt("fertilidad");
				imagen = miRs.getString("imagen");

//				System.out.println(equipo);

				Pokemon pokemon = new Pokemon(id, nombre, mote, vida, ataque, defensa, ataqueSp, defensaSp, velocidad,
						stamina, nivel, fertilidad, equipo, estado, imagen);

				comprobarSiExisteMovimiento(pokemon,id_movimiento1);
				comprobarSiExisteMovimiento(pokemon,id_movimiento1);
				comprobarSiExisteMovimiento(pokemon,id_movimiento1);
				comprobarSiExisteMovimiento(pokemon,id_movimiento1);
				
				// para hacer pruebas cargo los mismo movimientos a todos los pokemon de todos
				// los entrenadores
//				pokemon.setMoves(CargarMoves.getMovimientos());

				System.out.println("estos son los movimientos " + pokemon.getMoves().toString());

				// prueba para ver si va el método criar, luego lo borraré
//				pokemon.getMoves().add(new Move("patada"));
//				pokemon.getMoves().add(new Move("puñetazo"));

				if (equipo.equalsIgnoreCase("SI")) {

					entrenador.getEquipoPokemon().add(pokemon);
				}

				else {

					entrenador.getTodosLosPokemon().add(pokemon);
				}

//				System.out.println("equio: "+entrenador.getEquipoPokemon().toString());
//				System.out.println("TODOS: "+entrenador.getTodosLosPokemon().toString());

//	System.out.println(todosLosPokemon.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//comprueba que el la tabla pokemon_entrenador el id_movimiento no esté a cero, si es asi inserta el movimiento
	//en la lista de movimiento del pokemon
	private static void comprobarSiExisteMovimiento(Pokemon p, int idMovimiento) {
		
		if (idMovimiento != 0) {

			Move movimiento = CargarMoves.cargarMovesEnPokemon(idMovimiento);

			p.getMoves().add(movimiento);
		}
	}
}
