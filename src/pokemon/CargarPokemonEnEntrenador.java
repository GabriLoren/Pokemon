package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CargarPokemonEnEntrenador {
	
	
	
	public static LinkedList<Pokemon> pokemon;

	public static void cargarPokemonEnEntrenador(Trainer entrenador) {

		Pokemon pokemon1,pokemon2,pokemon3;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM POKEMON where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// cargo el pokemon1 
			miPSt.setString(1, "1");
			ResultSet miRs = miPSt.executeQuery();

			String nombre = "";
			int id = 0;
			int vida = 0;
			while (miRs.next()) {

				
				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				vida = Integer.parseInt(miRs.getString(3));

			}
			// cargo el pokemon2 
			miPSt.setString(1, "1");
			ResultSet miRs2 = miPSt.executeQuery();

			String nombre2 = "";
			int id2 = 0;
			int vida2 = 0;
			while (miRs2.next()) {

				
				id2 = Integer.parseInt(miRs2.getString(1));
				nombre2 = miRs2.getString(2);
				vida2 = Integer.parseInt(miRs2.getString(3));

			}
			// cargo el pokemon3 
						miPSt.setString(1, "1");
						ResultSet miRs3 = miPSt.executeQuery();

						String nombre3 = "";
						int id3 = 0;
						int vida3 = 0;
						while (miRs3.next()) {

							
							id3 = Integer.parseInt(miRs3.getString(1));
							nombre3 = miRs3.getString(2);
							vida3 = Integer.parseInt(miRs3.getString(3));

						}
//doy valores a los atributos del pokemon1 obteniendolos de la bbdd
			pokemon1 = new Pokemon(id,nombre,vida);
			pokemon2 = new Pokemon(id2,nombre2,vida2);
			pokemon3 = new Pokemon(id3,nombre3,vida3);
			
			
			//cargamos los movimientos del pokemon1
			CargarMoves.cargarMovimientos(pokemon1);
			CargarMoves.cargarMovimientos(pokemon2);
			CargarMoves.cargarMovimientos(pokemon3);
			
		//creo una LinkedList para insertar en ella los pokemon que tiene el entrenador
		
			pokemon = new LinkedList<Pokemon>();
			
			//añado el pokemon uno a su likendlist

			pokemon.add(pokemon1);
			pokemon.add(pokemon2);
			pokemon.add(pokemon3);
			
			//inserto la linkedlist al entrenador
			
			entrenador.setEquipoPokemon(pokemon);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	

}
