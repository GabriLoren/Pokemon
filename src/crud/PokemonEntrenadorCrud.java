package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import funcionalidades.GenerarID;
import modelo.Pokemon;

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
}
