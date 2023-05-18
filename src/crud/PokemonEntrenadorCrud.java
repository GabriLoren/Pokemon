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

	// inserta en la BbDd(tabla POKEMON_ENTRENADOR) el pokemon que se le pasa por
	// parámetro con el idEntrenador que se le pasa por parámetro
	public static void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon, Trainer entrenador) {

		int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");

		int idPokedex = pokemon.getId();

		pokemon.setId(idGenerado);

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentencia = "INSERT INTO POKEMON_ENTRENADOR (ID,ID_POKEDEX,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,NIVEL,"
					+ "FERTILIDAD,EQUIPO,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4,ID_OBJETO,EXP)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, pokemon.getId());// id
			miPSt.setLong(2, idPokedex);// id_pokedex
//			miPSt.setString(2, pokemon.getName());// nombre
			miPSt.setString(3, pokemon.getName());// el mote por defecto es el ombre del pokemon
			miPSt.setLong(4, entrenador.getId());// id_entrenador que está actualmemnte jugando
			miPSt.setLong(5, pokemon.getVit());
			miPSt.setLong(6, pokemon.getAtk());
			miPSt.setLong(7, pokemon.getDef());
			miPSt.setLong(8, pokemon.getSpAtk());
			miPSt.setLong(9, pokemon.getSpDef());
			miPSt.setLong(10, pokemon.getSpeed());
//			miPSt.setLong(10, pokemon.getStamina());
			miPSt.setLong(11, pokemon.getLevel());
			miPSt.setLong(12, pokemon.getFertility());

			if (entrenador.getEquipoPokemon().size() < 6)
				miPSt.setString(13, "SI");
			else
				miPSt.setString(13, "NO");
//			miPSt.setString(15, pokemon.getImagen());
			// AL CAPTURARLO TODOS TIENEN EL MISMO MOVIMIENTO POR AHORA, EL ID 1 DE LA TABLA
			// MOVE
			miPSt.setLong(14, CargarMoves.getMovimientos().get(0).getId());
			// EL RESTO DE MOVES EL ID ES 0 QUE ES LO MISMO QUE NO HBER MOVIMIENTO
			miPSt.setLong(15, 0);
			miPSt.setLong(16, 0);
			miPSt.setLong(17, 0);
			miPSt.setLong(18, pokemon.getObject().getId());
			miPSt.setLong(19, 0);

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarEnBbDdElPokemonHijo(Pokemon pokemon, Trainer entrenador) {

		int idGenerado = GenerarID.generaID("SELECT ID FROM POKEMON_ENTRENADOR");

		pokemon.setId(idGenerado);

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentencia = "INSERT INTO POKEMON_ENTRENADOR (ID,ID_POKEDEX,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,NIVEL,"
					+ "FERTILIDAD,EQUIPO,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4,EXP,ID_OBJETO)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, pokemon.getId());// id
			miPSt.setLong(2, pokemon.getIdPokedex());// id_pokedex
			miPSt.setString(3, pokemon.getNickname());//
			miPSt.setLong(4, entrenador.getId());// id_entrenador que está actualmemnte jugando
			miPSt.setLong(5, pokemon.getVit());
			miPSt.setLong(6, pokemon.getAtk());
			miPSt.setLong(7, pokemon.getDef());
			miPSt.setLong(8, pokemon.getSpAtk());
			miPSt.setLong(9, pokemon.getSpDef());
			miPSt.setLong(10, pokemon.getSpeed());
			miPSt.setLong(11, pokemon.getLevel());
			miPSt.setLong(12, pokemon.getFertility());
//			miPSt.setLong(13, 0);

			if (entrenador.getEquipoPokemon().size() < 6)
				miPSt.setString(13, "SI");
			else
				miPSt.setString(13, "NO");
//			miPSt.setString(15, pokemon.getImagen());
			// AL CAPTURARLO TODOS TIENEN EL MISMO MOVIMIENTO POR AHORA, EL ID 1 DE LA TABLA
			// MOVE
			miPSt.setLong(14, CargarMoves.getMovimientos().get(0).getId());
			// EL RESTO DE MOVES EL ID ES 0 QUE ES LO MISMO QUE NO HBER MOVIMIENTO
			miPSt.setLong(15, 0);
			miPSt.setLong(16, 0);
			miPSt.setLong(17, 0);
			miPSt.setLong(18, 0);
			miPSt.setLong(19, pokemon.getObject().getId());
			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void cargarPokemonEnEntrenador(Trainer entrenador) {

//		LinkedList<Pokemon> todosLosPokemon = new LinkedList<>();
//		LinkedList<Pokemon> equipoPokemon = new LinkedList<>();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentecia = "SELECT PE.*,P.nombre,P.imagen,P.tipo1,P.tipo2,P.stamina FROM POKEMON_ENTRENADOR PE JOIN pokemon P ON PE.id_pokedex=P.id WHERE ID_ENTRENADOR=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// idEntrenador es el id del entrenador que hemos cargado previamente
			miPSt.setLong(1, entrenador.getId());
			ResultSet miRs = miPSt.executeQuery();

			int id = 0;
			int idPokedex = 0;
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
			int id_movimiento2 = 0;
			int id_movimiento3 = 0;
			int id_movimiento4 = 0;
			int exp = 0;
			int id_objeto = 0;

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				idPokedex = miRs.getInt("id_pokedex");
				nombre = miRs.getString("nombre");
				mote = miRs.getString("mote");
				vida = miRs.getInt("vida");
				ataque = miRs.getInt("ataque");
				defensa = miRs.getInt("defensa");
				ataqueSp = miRs.getInt("ataque_sp");
				defensaSp = miRs.getInt("defensa_sp");
				velocidad = miRs.getInt("velocidad");
				stamina = miRs.getInt("stamina");
				nivel = miRs.getInt("nivel");
				equipo = miRs.getString("equipo");
				id_movimiento1 = miRs.getInt("id_movimiento1");
				id_movimiento2 = miRs.getInt("id_movimiento2");
				id_movimiento3 = miRs.getInt("id_movimiento3");
				id_movimiento4 = miRs.getInt("id_movimiento4");
				fertilidad = miRs.getInt("fertilidad");
				imagen = miRs.getString("imagen");
				exp = miRs.getInt("exp");
				id_objeto = miRs.getInt("id_objeto");

				System.out.println("movimiento1 " + id_movimiento1);
				System.out.println("movimiento1 " + id_movimiento2);
				System.out.println("movimiento1 " + id_movimiento3);
				System.out.println("movimiento1 " + id_movimiento4);

//				System.out.println(equipo);

				Pokemon pokemon = new Pokemon(id, idPokedex, nombre, mote, vida, ataque, defensa, ataqueSp, defensaSp,
						velocidad, stamina, nivel, fertilidad, equipo, estado, imagen, exp);

				System.out.println("estos son los movimientos " + pokemon.getMoves().toString());

				pokemon.setObject(CargarTodosLosObjetos.obtenerObjeto(id_objeto));

				System.out.println("Este es el objeto " + pokemon.getObject());

				comprobarSiExisteMovimiento(pokemon, id_movimiento1);
				comprobarSiExisteMovimiento(pokemon, id_movimiento2);
				comprobarSiExisteMovimiento(pokemon, id_movimiento3);
				comprobarSiExisteMovimiento(pokemon, id_movimiento4);

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

	public static void actualizarPokemonEnBbDd(Pokemon pokemon) {

		System.out.println("mote " + pokemon.getNickname());

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			String sentencia = "UPDATE POKEMON_ENTRENADOR SET VIDA=?, ATAQUE=? ,defensa=?, ATAQUE_SP=?,DEFENSA_SP=?,"
					+ "VELOCIDAD=?,NIVEL=?, FERTILIDAD=?,  EQUIPO=? ,MOTE=?, ID_OBJETO=?, EXP=?,  ID_MOVIMIENTO1=?,ID_MOVIMIENTO2=?,ID_MOVIMIENTO3=?,ID_MOVIMIENTO4=? WHERE ID=?";

//					(ID,NOMBRE,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,STAMINA,NIVEL)"
//					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, pokemon.getVit());
			miPSt.setLong(2, pokemon.getAtk());
			miPSt.setLong(3, pokemon.getDef());
			miPSt.setLong(4, pokemon.getSpAtk());
			miPSt.setLong(5, pokemon.getSpDef());
			miPSt.setLong(6, pokemon.getSpeed());
//			miPSt.setLong(7, pokemon.getStamina());
			miPSt.setLong(7, pokemon.getLevel());
			miPSt.setLong(8, pokemon.getFertility());
			miPSt.setString(9, pokemon.getEquipo());
			miPSt.setString(10, pokemon.getNickname());
			try {
				miPSt.setInt(11, pokemon.getObject().getId());
			} catch (Exception e) {
				// TODO: handle exception
				miPSt.setInt(11, 0);
			}

			miPSt.setInt(12, pokemon.getExp());
			miPSt.setInt(13, pokemon.getMoves().get(0).getId());
			miPSt.setInt(14, pokemon.getMoves().get(1).getId());
			miPSt.setInt(15, pokemon.getMoves().get(2).getId());
			miPSt.setInt(16, pokemon.getMoves().get(3).getId());
			
			
			miPSt.setLong(17, pokemon.getId());

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// comprueba que el la tabla pokemon_entrenador el id_movimiento no esté a cero,
	// si es asi inserta el movimiento
	// en la lista de movimiento del pokemon
	private static void comprobarSiExisteMovimiento(Pokemon p, int idMovimiento) {

		if (idMovimiento != 0) {

			Move movimiento = CargarMoves.cargarMovesEnPokemon(idMovimiento);

			p.getMoves().add(movimiento);
		}
	}
}
