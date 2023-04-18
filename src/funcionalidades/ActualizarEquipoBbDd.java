package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pokemon;

public class ActualizarEquipoBbDd {

	//Actualiza en la BbDd si está en el equipo o no
	public static void actualizarEquipoBbDd(Pokemon pokemon) {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

//			UPDATE articulo SET nom_articulo='Impresora Láser' WHERE cod_articulo=8;

			String sentencia = "UPDATE POKEMON_ENTRENADOR SET EQUIPO=?";

//					(ID,NOMBRE,MOTE,ID_ENTRENADOR,VIDA,ATAQUE,DEFENSA,ATAQUE_SP,DEFENSA_SP,VELOCIDAD,STAMINA,NIVEL)"
//					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement miPSt = miCon.prepareStatement(sentencia);
			miPSt.setString(1, pokemon.getEquipo());
//			

			miPSt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
