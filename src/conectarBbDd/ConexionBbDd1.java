package conectarBbDd;

import java.sql.*;

import modelo.Category;
import modelo.Move;
import modelo.Types;

public class ConexionBbDd1 {

	

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT nombre FROM MOVE where id=1");
			
			String nombre="";
			while (miRs.next()) {
				
				nombre=miRs.getString(1);
			}
			
			
			System.out.println(nombre);
			
			Move move2 = new Move("cabezazo",1, Category.ATK, 20, Types.NORMAL, "", 0, 0);
			
			move2.setName(nombre);
			
			System.out.println(move2.getName());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
	

}
