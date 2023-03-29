package pokemon;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cargar.CargarMoves;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class VistaCapturaController {
	@FXML
	private Button capturarPokemon;
	@FXML
	private Button bucarPokemon;
	@FXML
	private Label pokemonEncontrado;
	@FXML
	private Label pokemonCapturado;
	
	private Pokemon pokemon;

	// Event Listener on Button[#capturarPokemon].onAction
	@FXML
	public void capturarPokemon(ActionEvent event) {
		
		if(pokemon!=null) {
			Captura.capturaPokemon(pokemon);
			
		}
	
		else pokemonEncontrado.setText("Aún no has encontrado ningun pokemon");
	}
	// Event Listener on Button[#bucarPokemon].onAction
	@FXML
	public void bucarPokemon(ActionEvent event) {

		pokemon=Captura.generaPokemonAleatorio();
		
		pokemonEncontrado.setText("has enconrado un "+pokemon.getName());
		
		
	
//		try {
//
//			Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
//
//			String sentecia = "SELECT * FROM POKEMON where id=?";
//			PreparedStatement miPSt = miCon.prepareStatement(sentecia);
//
////			int aleatorio = (int) ((Math.random() * 3) + 1);
//			miPSt.setString(1, "1");
//
//			ResultSet miRs = miPSt.executeQuery();
//
//		
//
//			while (miRs.next()) {
//
//				String name = miRs.getString(2);
//				int power = Integer.parseInt(miRs.getString(3));
//			}
//
//			pokemonCazar = new Pokemon(name);
//
//			CargarMoves.cargarMovimientos(pokemonCazar);
//
//			
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}
