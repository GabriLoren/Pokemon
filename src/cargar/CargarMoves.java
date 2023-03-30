package cargar;

import java.sql.*;
import java.util.LinkedList;

import modelo.Category;
import modelo.Move;
import modelo.Pokemon;
import modelo.Types;

public class CargarMoves {

	public static LinkedList<Move> moves;

	public static void cargarMovimientos(Pokemon pokemon) {

		Move move1, move2, move3;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			String sentecia = "SELECT * FROM MOVE where id=?";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);

			// cargo el movimieto 1
			miPSt.setString(1, "1");
			ResultSet miRs = miPSt.executeQuery();

			String nombre = "";
			int id = 0;
			int powe = 0;
			while (miRs.next()) {

				nombre = miRs.getString(2);
				id = Integer.parseInt(miRs.getString(1));
				powe = Integer.parseInt(miRs.getString(3));

			}

			miRs.close();

			// cargo el movimieto 2
			miPSt.setString(1, "2");
			ResultSet miRs2 = miPSt.executeQuery();

			String nombre2 = "";
			int id2 = 0;
			int powe2 = 0;
			while (miRs2.next()) {

				nombre2 = miRs2.getString(2);
				id2 = Integer.parseInt(miRs2.getString(1));
				powe2 = Integer.parseInt(miRs2.getString(3));

			}

			miRs.close();
			
			// cargo el movimieto 3
						miPSt.setString(1, "3");
						ResultSet miRs3 = miPSt.executeQuery();

						String nombre3 = "";
						int id3 = 0;
						int powe3 = 0;
						while (miRs3.next()) {

							nombre3 = miRs3.getString(2);
							id3 = Integer.parseInt(miRs3.getString(1));
							powe3 = Integer.parseInt(miRs3.getString(3));

						}

						miRs.close();

			move1 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);
			move2 = new Move(nombre2, id2, Category.ATK, powe2, Types.NORMAL, "", 0, 0);
			move3 = new Move(nombre3, id3, Category.ATK, powe3, Types.NORMAL, "", 0, 0);

			moves = new LinkedList<Move>();

			moves.add(move1);
			moves.add(move2);
			moves.add(move3);

			pokemon.setMoves(moves);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
