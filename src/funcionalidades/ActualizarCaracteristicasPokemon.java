package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pokemon;

public class ActualizarCaracteristicasPokemon {

	public static void actualizarPokemonEnBbDd(Pokemon pokemon) {
		
		System.out.println("VITALIDAD POKEMON:"+pokemon.getVit());

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

//			UPDATE articulo SET nom_articulo='Impresora Láser' WHERE cod_articulo=8;

			String sentencia = "UPDATE POKEMON_ENTRENADOR SET VIDA=?, ATAQUE=? ,defensa=?, ATAQUE_SP=?,DEFENSA_SP=?,"
					+ "VELOCIDAD=?,STAMINA=?,NIVEL=? WHERE ID=?";

//					(ID,NOMBRE,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,STAMINA,NIVEL)"
//					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setLong(1, pokemon.getVit());
			miPSt.setLong(2, pokemon.getAtk());
			miPSt.setLong(3, pokemon.getDef());
			miPSt.setLong(4, pokemon.getSpAtk());
			miPSt.setLong(5, pokemon.getSpDef());
			miPSt.setLong(6, pokemon.getSpeed());
			miPSt.setLong(7, pokemon.getStamina());
			miPSt.setLong(8, pokemon.getLevel());
			miPSt.setLong(9, pokemon.getId());
//			

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
