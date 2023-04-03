package funcionalidades;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearUsuarioNuevo {
	// si no existe el nombre de usuario en la BbDd crea el usuario nuevo y devuelve true
public static boolean crearUsuarioNuevo(String nombreUsuarioNuevo) {

	
		if (ComprobarUsuarioExiste.ComprobarUsuarioExiste(nombreUsuarioNuevo)==false) {
			insertraUSuarioNuevo(nombreUsuarioNuevo);
			return true;
		}
		return false;

	}

	public static void insertraUSuarioNuevo(String nombreUsuarioNuevo) {

		int idNuevoUsuario = GenerarID.generaID("SELECT ID FROM ENTRENADOR");

		String nombreUsuarioNuevoMayuscula = nombreUsuarioNuevo.toUpperCase();

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			String sentecia = "INSERT INTO ENTRENADOR (ID,NOMBRE) VALUES (?,?)";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
			miPSt.setLong(1, idNuevoUsuario);
			miPSt.setString(2, nombreUsuarioNuevoMayuscula);

			miPSt.executeUpdate();

			miPSt.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
