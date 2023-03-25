package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class CargarMoves {

	public static void main(String[] args) {

		
		Move move1, move2, move3;
			
			try {

				Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

				Statement miSt = miCon.createStatement();

				ResultSet miRs = miSt.executeQuery("SELECT * FROM MOVE where id=1");

				String nombre = "";
				int id = 0;
				int powe = 0;
				while (miRs.next()) {

					nombre = miRs.getString(2);
					id = Integer.parseInt(miRs.getString(1));
					powe = Integer.parseInt(miRs.getString(3));

				}

				move1 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);
				move2 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);
				move3 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);

				LinkedList<Move> moves= new LinkedList<Move>();

				moves.add(move1);
				moves.add(move2);
				moves.add(move3);
				
				Pokemon pokemon1= new Pokemon(moves);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}


