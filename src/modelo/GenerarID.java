package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerarID {

	
	// genera un id que no exista en la tabla que queremos insertar un nuevo objeto
	public static int generaID(String sentencia) {
		
		

		int id = 0;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = sentencia;
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
			}

			miRs.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id + 1;
	}
}
