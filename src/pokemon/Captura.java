package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cargar.CargarMoves;

public class Captura {
	// genera un pokemon aleatorio de la tabla pokemon para capturarlo
	public static Pokemon generaPokemonAleatorio() {
		Pokemon pokemonCazar = null;
		String name = "";

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM POKEMON where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
//MULTIPLICAMOS POR EL NÚMERO DE POKEMON QUE HAY EN LA TABLA POKEMON Y LE SUMAMOS UNO PARA SACAR A UN POKEMON ALEATORIO QUE SE ENCUENTRE EN LA TBALA POKEMON
			int aleatorio = (int) ((Math.random() * 3) + 1);
			miPSt.setLong(1, aleatorio);

			ResultSet miRs = miPSt.executeQuery();

			while (miRs.next()) {

				name = miRs.getString(2);
				int power = Integer.parseInt(miRs.getString(3));
			}

			pokemonCazar = new Pokemon(name);

			CargarMoves.cargarMovimientos(pokemonCazar);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemonCazar;

	}

	// genera un id que no esté en la tabla pokemon_entrenador
	public static int generaID() {

		int id = 0;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM POKEMON_ENTRENADOR";
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

		return id+1;
	}

	// inserta en la tabla pokemon_entrenador el pokemon capturado que pasa a formar
	// parte de nuestros pokemon
	public static void capturaPokemon(Pokemon pokemon, Trainer entrenador) {
		
		try {
			// 1.Crear conexion
			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			// 2.crear statement
//			Statement miSt = miCon.createStatement();

			// 2.crear prepareStatemen
			String inSQL = "INSERT INTO POKEMON_ENTRENADOR (ID,NOMBRE_POKEMON,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4,ID_ENTRENADOR)"
					+ " VALUES (?,?,?,?,?,?,?)";
//			
			PreparedStatement miPSt = miCon.prepareStatement(inSQL);
			miPSt.setLong(1, generaID());//id
			miPSt.setString(2, pokemon.getName());// nombre
//			miPSt.setLong(1, (int)(Math.random()*1000+1));// id
//		

			miPSt.setString(3, "1");// movimiento1
			miPSt.setString(4, "2");// movimiento2
			miPSt.setString(5, "3");// movimiento3
			miPSt.setString(6, "1");// movimiento4
			miPSt.setLong(7, entrenador.getId());// id_entrenador

			// 3.Crear instrucción sql (Insertar en tabla)
//			String inSQL = "INSERT INTO POKEMON_ENTRENADOR (ID,ID_ENTRENADOR,ID_MOVIMIENTO1,ID_MOVIMIENTO2,ID_MOVIMIENTO3,ID_MOVIMIENTO4,)"
//					+ " VALUES (4,'RODILLAZO',40)";
//			String inSQL = "UPDATE MOVE SET POWE=50 WHERE NOMBRE='RODILLAZO'";
//			String inSQL = "DELETE FROM MOVE WHERE NOMBRE='RODILLAZO'";

			// 3.Ejecutar instrucción sql
//			ResultSet miRs = miPSt.executeQuery("SELECT * FROM MOVE");  
//			ResultSet miRs = miPSt.executeQuery(); 

			// 4.EJECUTAR SQL
			miPSt.executeUpdate();

//			miRs.close();

//			miCon.close();

			// 4.leer resultado

//			while (miRs.next()) {
//
////				System.out.println(miRs.getString(1) + " " + miRs.getString(2) + " " + miRs.getString(3));
//				System.out.println(miRs.getString(1));
//			}
//			
//			miRs.close();
//			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
