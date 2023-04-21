package funcionalidades;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cargar.CargarTodosLosEntrenadores;
import modelo.Trainer;

public class CrearUsuarioNuevo {
	static Trainer entrenadorNuevo=new Trainer(0, null, 0);
	
	// si no existe el nombre de usuario en la BbDd crea el usuario nuevo y devuelve true
public static boolean crearUsuarioNuevo(String nombreUsuarioNuevo) {


	
		if (ComprobarUsuarioExiste.ComprobarUsuarioExiste(nombreUsuarioNuevo)==false) {
			
			int idNuevoUsuario = GenerarID.generaID("SELECT ID FROM ENTRENADOR");
			
			entrenadorNuevo.setId(idNuevoUsuario);
			
			entrenadorNuevo.setName(nombreUsuarioNuevo.toUpperCase());
			
			//por defecto al crear un usuario nuevo se le inserta un número de pokedollar determinado
			entrenadorNuevo.setPokeDollar(1000);
			
			CargarTodosLosEntrenadores.getTodosLosEntrenadores().add(entrenadorNuevo);
			insertraUSuarioNuevo(entrenadorNuevo);
			return true;
		}
		return false;

	}

	public static void insertraUSuarioNuevo(Trainer entrenador) {


		try {

			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			String sentecia = "INSERT INTO ENTRENADOR (ID,NOMBRE,POKEDOLLAR) VALUES (?,?,?)";
			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
			miPSt.setLong(1, entrenador.getId());
			miPSt.setString(2, entrenador.getName());
			miPSt.setLong(3, 1000);
			

			miPSt.executeUpdate();

			miPSt.close();
			miCon.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
