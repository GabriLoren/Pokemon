package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cargar.CargarMoves;
import modelo.Pokemon;

public class Captura {
	
	public static void captura(Pokemon pokemon, int idEntrenador) {
		
//		pokemon.setNickname(mote);
		
		insertarEnBbDdElPokemonEncontrado(pokemon, idEntrenador);
		
	}

	public static void insertarEnBbDdElPokemonEncontrado(Pokemon pokemon, int idEntrenador) {
		int idGenerado = GenerarID.generaID("SELECT POKEMON_ID FROM POKEMON_TRAINER");

		// nombre del pokemon encontrado previamente
//		String nombre = pokemon.getName();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");
			
			

			 


			String sentencia = "INSERT INTO POKEMON_TRAINER (pokemon_id,POKEDEX_NUM,trainer_id,nickname,type1,type2,vitality,attack,defense,sp_defense,sp_attack,speed,"
					+ "stamina,level,in_team,exp,fertility,move1)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setInt(1, idGenerado);// id
			miPSt.setInt(2, pokemon.getPokedexNum());// nombre 
			miPSt.setInt(3, idEntrenador);// el mote por defecto es el ombre del pokemon
			miPSt.setString(4, pokemon.getNickname());// id_entrenador que está actualmemnte jugando
			miPSt.setString(5, pokemon.getType1().toString());
			if(pokemon.getType2()!=null)
			miPSt.setString(6, pokemon.getType2().toString());
			else
				miPSt.setString(6, null);
			miPSt.setInt(7, pokemon.getVit());
			miPSt.setInt(8, pokemon.getAtk());
			miPSt.setInt(9, pokemon.getDef());
			miPSt.setInt(10, pokemon.getSpDef());
			miPSt.setInt(11, pokemon.getSpAtk());
			miPSt.setInt(12, pokemon.getSpeed());
//			miPSt.setLong(13, pokemon.getFertility());
			miPSt.setInt(13, pokemon.getStamina());
			miPSt.setInt(14, pokemon.getLevel());
			miPSt.setBoolean(15, false);
		
			//EL RESTO DE MOVES EL ID ES 0 QUE ES LO MISMO QUE NO HBER MOVIMIENTO
			miPSt.setInt(16, pokemon.getExp());
			miPSt.setInt(17, pokemon.getFertility());
			//AL CAPTURARLO TODOS TIENEN EL MISMO MOVIMIENTO POR AHORA, EL ID 1 DE LA TABLA MOVE
			miPSt.setInt(18, CargarMoves.getMovimientos().getFirst().getId());
			
			

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
