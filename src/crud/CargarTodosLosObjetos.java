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
	private static  Obj objeto;
	
	public static void cargarTododLosObjetos() {
		
		
		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

			Statement miSt = miCon.createStatement();

			ResultSet miRs = miSt.executeQuery("SELECT * FROM OBJECT");

			while (miRs.next()) {

				id = Integer.parseInt(miRs.getString(1));
				nombre = miRs.getString(2);
				

				objeto = new Obj(id,nombre);
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
