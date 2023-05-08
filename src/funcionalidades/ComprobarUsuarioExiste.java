package funcionalidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ComprobarUsuarioExiste {
	//devuelve true si el usuario existe en la BbDd
	public static boolean ComprobarUsuarioExiste (String nombreUsuario) {
		
		boolean usuarioExiste=false;
		
		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT NOMBRE FROM ENTRENADOR");

			String nombre = "";
			while (miRs.next()) {

				nombre = miRs.getString(1);

				if (nombre.equalsIgnoreCase(nombreUsuario)) {
					usuarioExiste = true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		return usuarioExiste;
		
	}

}
