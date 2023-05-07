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
	
	private static LinkedList<Obj>todosLosObjetos=new LinkedList<>();
	
	private static int id;
	private static  String nombre;
	private static int precio;
	private static int atk;
	private static int def;
	private static int spDef;
	private static int speed;
	private static int stamina;
	
	public static void cargarTododLosObjetos() {
		
		
		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM OBJECT");

			while (miRs.next()) {

				id = miRs.getInt(1);
				nombre = miRs.getString(2);
				precio=miRs.getInt("precio");
				atk=miRs.getInt("ataque");
				def=miRs.getInt("defensa");
				spDef=miRs.getInt("defensa_sp");
				speed=miRs.getInt("velocidad");
				stamina=miRs.getInt("estamina");
		

				Obj objeto = new Obj(id, nombre, precio,atk, def, spDef, 2, stamina);
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
