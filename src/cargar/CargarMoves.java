package cargar;

import java.sql.*;

import java.util.LinkedList;

import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;
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

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();
			ResultSet miRs = miSt.executeQuery("SELECT * FROM MOVIMIETO");

			Move movimiento;
			int id = 0;
			String nombre = "";
			String categoria = "";
			int potencia = 0;
			int costeEstamina=0;

			while (miRs.next()) {

				id = miRs.getInt("id");
				nombre = miRs.getString("nombre");
				categoria = miRs.getString("categoria");
				potencia = miRs.getInt("potencia");
				costeEstamina=miRs.getInt("coste_estamina");

				movimiento = new Move(nombre, id, categoria, potencia, null, " ", 0, 0,costeEstamina);
				
				System.out.println("movimiento "+movimiento.toString());

				movimientos.add(movimiento);

			}

			miRs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//devuelve el movimiento correspondiente al id del movimiento introducido por parámetro
	public static Move cargarMovesEnPokemon(int idMove) {
		Move movimiento=null;
		
		for(int i=0;i<movimientos.size();i++) {
			
			if(idMove==movimientos.get(i).getId())
			
			movimiento=movimientos.get(i);
		}
		return movimiento;
	}

}
