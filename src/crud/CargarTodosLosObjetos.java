package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import modelo.Obj;
import modelo.Pokemon;

public class CargarTodosLosObjetos {

	private static LinkedList<Obj> todosLosObjetos = new LinkedList<>();

	private static int id;
	private static String nombre;
	private static int precio;
	private static double atk;
	private static double def;
	private static double spDef;
	private static double speed;
	private static double stamina;

	public static void cargarTododLosObjetos() {

		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM OBJECTO");

			while (miRs.next()) {

				id = miRs.getInt(1);
				nombre = miRs.getString(2);
				precio = miRs.getInt("precio");
				atk = miRs.getDouble("ataque");
				def = miRs.getDouble("defensa");
				spDef = miRs.getDouble("defensa_sp");
				speed = miRs.getDouble("velocidad");
				stamina = miRs.getDouble("estamina");

				Obj objeto = new Obj(id, nombre, precio, atk, def, spDef, speed, stamina);
				todosLosObjetos.add(objeto);
			}
			System.out.println("metodo cargarTododLosObjetos funciona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static LinkedList<Obj> getTodosLosObjetos() {
		return todosLosObjetos;
	}

}
