package conectarBbDd;

import java.sql.*;

import pokemon.Category;
import pokemon.Move;
import pokemon.Types;

public class ConexionBbDd {

	public static void main(String[] args) {

		try {
			// 1.Crear conexion
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			// 2.crear statement
			Statement miSt = miCon.createStatement();

			// 3.Ejecutar instrucción sql
			ResultSet miRs = miSt.executeQuery("SELECT nombre FROM MOVE WHERE ID=1 ");

			// 4.leer resultado

			while (miRs.next()) {

				System.out.println(miRs.getString(1) + " " + miRs.getString(2) + " " + miRs.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
