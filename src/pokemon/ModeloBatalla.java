package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloBatalla {
	static int power=0;
	
	Pokemon pokemon1= new Pokemon();
	Pokemon pokemon2= new Pokemon();

	public static int realizaAtaque(String valorDeId) {// Pokemon pokemonAtacante, Pokemon pokemonDefensor) {


		try {
	
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");


			String sentecia = "SELECT * FROM MOVE where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
			miPSt.setString(1, valorDeId);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

			power = Integer.parseInt(miRs.getString(3));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return power;
	}
	
	
	public static void restarVida(Pokemon pokemon2) {
		
		this.pokemon2
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
