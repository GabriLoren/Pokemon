package conectarBbDd;

import java.sql.*;

import modelo.Category;
import modelo.Move;
import modelo.Types;

public class ConexionBbDd {

	public static void main(String[] args) {

		try {
			// 1.Crear conexion
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			// 2.crear statement
//			Statement miSt = miCon.createStatement();
			
			//2.crear prepareStatemen
			String sentecia="SELECT * FROM MOVE where id=?";
			PreparedStatement miPSt=miCon.prepareStatement(sentecia);
			miPSt.setString(1, "1");
		
			

			// 3.Crear instrucción sql (Insertar en tabla)
//			String inSQL = "INSERT INTO MOVE (ID,NOMBRE,POWE) VALUES (4,'RODILLAZO',40)";
//			String inSQL = "UPDATE MOVE SET POWE=50 WHERE NOMBRE='RODILLAZO'";
//			String inSQL = "DELETE FROM MOVE WHERE NOMBRE='RODILLAZO'";

			// 3.Ejecutar instrucción sql
//			ResultSet miRs = miPSt.executeQuery("SELECT * FROM MOVE");  
			ResultSet miRs = miPSt.executeQuery(); 
		 
			
			//4.EJECUTAR SQL
//			miSt.executeUpdate(inSQL);
			
			miRs.close();
			
//			miCon.close();

			// 4.leer resultado

			while (miRs.next()) {

//				System.out.println(miRs.getString(1) + " " + miRs.getString(2) + " " + miRs.getString(3));
				System.out.println(miRs.getString(1));
			}
			
			miRs.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
