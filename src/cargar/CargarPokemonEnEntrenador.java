package cargar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.Move;
import modelo.Obj;
import modelo.Pokemon;
import modelo.Trainer;
import modelo.Types;

public class CargarPokemonEnEntrenador {

//	private LinkedList<Pokemon> todosLosPokemon = new LinkedList<>();

	public static void cargarPokemonEnEntrenador(Trainer entrenador) {

//		LinkedList<Pokemon> todosLosPokemon = new LinkedList<>();
//		LinkedList<Pokemon> equipoPokemon = new LinkedList<>();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentecia = "SELECT PT.*, P.NAME, P.SPRITE FROM POKEDEX AS JOIN POKEMON_TRAINER AS PT ON P.POKEDEX_NUM=PT.POKEDEX_NUM WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamente
			miPSt.setLong(1, entrenador.getId());
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			String nombre="";
			String nickname = "";
			String type1 = "";
			String type2 = "";
			int vitality = 0;
			int ataque = 0;
			int defensa = 0;
			int ataqueSp = 0;
			int defensaSp = 0;
			int velocidad = 0;
			int stamina = 0;
			String gender = "";
			int nivel = 0;
			boolean equipo = false;
			int exp = 0;
			String imagen = "";
			int id_movimiento1 =0;
			int id_movimiento2=0;
			int id_movimiento3=0;
			int id_movimiento4=0;
			//aún no lo tengo en cuenta
			int object=0;
			int fertilidad = 0;
		
			
			
//			id_objeto int);

			while (miRs.next()) {

				id = miRs.getInt("pokemon_id");
				nombre=miRs.getString("name");
				nickname = miRs.getString("nickname");
				type1 = miRs.getString("type1");
				type2 = miRs.getString("type2");
				vitality = miRs.getInt("vitality");
				ataque = miRs.getInt("attack");
				defensa = miRs.getInt("defense");
				defensaSp = miRs.getInt("sp_defense");
				ataqueSp = miRs.getInt("sp_attack");
				velocidad = miRs.getInt("speed");
				stamina = miRs.getInt("stamina");
				gender = miRs.getString("gender");
				nivel = miRs.getInt("level");
				equipo = miRs.getBoolean("in_team");
				exp = miRs.getInt("exp");
				imagen = miRs.getString("sprite");
				id_movimiento1 = miRs.getInt("move1");
				id_movimiento2 = miRs.getInt("move2");
				id_movimiento3 = miRs.getInt("move3");
				id_movimiento4 = miRs.getInt("move4");
				fertilidad=miRs.getInt("fertility");
				
				
				
//				fertilidad = miRs.getInt("fertilidad");
				

//				System.out.println(equipo);

				Pokemon pokemon = new Pokemon( id,  nombre,  nickname,  Types.valueOf(type1),  Types.valueOf(type2),  vitality, ataque, defensa, ataqueSp,
						defensaSp, velocidad, stamina, nivel, equipo, exp,  imagen, fertilidad);

				comprobarSiExisteMovimiento(pokemon,id_movimiento1);
				comprobarSiExisteMovimiento(pokemon,id_movimiento2);
				comprobarSiExisteMovimiento(pokemon,id_movimiento3);
				comprobarSiExisteMovimiento(pokemon,id_movimiento4);
				
				// para hacer pruebas cargo los mismo movimientos a todos los pokemon de todos
				// los entrenadores
//				pokemon.setMoves(CargarMoves.getMovimientos());

				System.out.println("estos son los movimientos " + pokemon.getMoves().toString());

				// prueba para ver si va el método criar, luego lo borraré
//				pokemon.getMoves().add(new Move("patada"));
//				pokemon.getMoves().add(new Move("puñetazo"));

				if (equipo==true) {

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
