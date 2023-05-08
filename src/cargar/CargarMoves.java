package cargar;

import java.sql.*;

import java.util.LinkedList;

import modelo.DmgTypes;
import modelo.Move;
import modelo.MoveCategory;
import modelo.Stats;
import modelo.Status;
import modelo.Types;

public class CargarMoves {

	public static LinkedList<Move> movimientos = new LinkedList<Move>();

	public static LinkedList<Move> getMovimientos() {
		return movimientos;
	}

	public static void setMovimientos(LinkedList<Move> movimientos) {
		CargarMoves.movimientos = movimientos;
	}

	// se carga todos los movimientos que hay en la BbDd
	public static void cargarMovimientos() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			Statement miSt = miCon.createStatement();
			ResultSet miRs = miSt.executeQuery("SELECT * FROM move");

			Move move;
			int id = 0;
			String name = "";
			String category = "";
			int power = 0;
			String type = "";
			String status = "";
			int turns = 0;
			double buff = 0;
			String stat = "";
			int staminaCost = 0;
			int lvlRequirement = 0;
			String dmgType = "";

			while (miRs.next()) {

				id = miRs.getInt("move_id");
				name = miRs.getString("name");
				power = miRs.getInt("power");
				type = miRs.getString("type");

				status = miRs.getString("status");

				turns = miRs.getInt("turns");
				buff = miRs.getDouble("buff");

				stat = miRs.getString("stat");

				staminaCost = miRs.getInt("stamina_cost");
				lvlRequirement = miRs.getInt("lvl_requirement");
				category = miRs.getString("category");

				dmgType = miRs.getString("dmg_type");

				move = new Move(name, id, MoveCategory.valueOf(category), power, Types.valueOf(type),
						Status.valueOf(status), turns, buff, staminaCost, Stats.valueOf(stat),
						DmgTypes.valueOf(dmgType), lvlRequirement);

				System.out.println("movimiento " + move.toString());

				movimientos.add(move);

			}

			miRs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// devuelve el movimiento correspondiente al id del movimiento introducido por
	// parámetro
	public static Move cargarMovesEnPokemon(int idMove) {
		Move movimiento = null;

		for (int i = 0; i < movimientos.size(); i++) {

			if (idMove == movimientos.get(i).getId())

				movimiento = movimientos.get(i);
		}
		return movimiento;
	}

}
