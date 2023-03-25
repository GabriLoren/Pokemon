package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class MainPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Obj obj = new Obj(1, "piedra", 0, 1.5, 0, 0, 0);

		Move move1, move2, move3;

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM MOVE where id=1");
			
			String nombre2="", nombre = "";
			int id=0, id2 = 0;
			int powe=0, powe2 = 0;
			while (miRs.next()) {

				nombre = miRs.getString(2);
				id = Integer.parseInt(miRs.getString(1));
				powe = Integer.parseInt(miRs.getString(3));

			}
			ResultSet miRs2 = miSt.executeQuery("SELECT * FROM MOVE where id=2");
			while (miRs2.next()) {

				nombre2 = miRs2.getString(2);
				id2 = Integer.parseInt(miRs2.getString(1));
				powe2 = Integer.parseInt(miRs2.getString(3));

			}

			move1 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);
			move2 = new Move(nombre2, id2, Category.ATK, powe2, Types.NORMAL, "", 0, 0);
			move3 = new Move(nombre, id, Category.ATK, powe, Types.NORMAL, "", 0, 0);

			LinkedList<Move> moves = new LinkedList<Move>();

			moves.add(move1);
			moves.add(move2);
			moves.add(move3);

			Pokemon myPokemon1 = new Pokemon(moves);
			Pokemon myPokemon2 = new Pokemon(moves);
			Pokemon myPokemon3 = new Pokemon(moves);

			Pokemon pokemonOponente1 = new Pokemon(moves);
			Pokemon pokemonOponente2 = new Pokemon(moves);
			Pokemon pokemonOponente3 = new Pokemon(moves);

			LinkedList<Pokemon> equipoPokemon1 = new LinkedList<Pokemon>();
			LinkedList<Pokemon> equipoPokemon2 = new LinkedList<Pokemon>();

			equipoPokemon1.add(myPokemon1);
			equipoPokemon1.add(myPokemon2);
			equipoPokemon1.add(myPokemon3);

			equipoPokemon2.add(pokemonOponente1);
			equipoPokemon2.add(pokemonOponente2);
//			equipoPokemon2.add(pokemonOponente3);

			Trainer gabriel = new Trainer("Gabriel", equipoPokemon1);
			Trainer alejandro = new Trainer("Alejandro", equipoPokemon2);

			Battle batalla1 = new Battle(gabriel, alejandro);

			batalla1.trainer1VsTrainer2();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
