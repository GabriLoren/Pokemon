package controlador;

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
import modelo.Captura;
import modelo.Pokemon;
import modelo.Trainer;

public class CapturaController {
	@FXML
	private Button capturarPokemon;
	@FXML
	private Button bucarPokemon;
	@FXML
	private Label pokemonEncontrado;
	@FXML
	private Label pokemonCapturado;
	
	private Pokemon pokemon;
	
	private Trainer entrenador;

	// Event Listener on Button[#capturarPokemon].onAction
	@FXML
	public void capturarPokemon(ActionEvent event) {
		entrenador=new Trainer(2);
		
		if(pokemon!=null) {
			Captura.capturaPokemon(pokemon,entrenador);
			
			pokemonCapturado.setText("Enhorabuenas has capturado un nuevo "+pokemon.getName());
			
			
		}
	
		else pokemonEncontrado.setText("Aún no has encontrado ningun pokemon");
	}
	// Event Listener on Button[#bucarPokemon].onAction
	@FXML
	public void bucarPokemon(ActionEvent event) {
		
		

		pokemon=Captura.generaPokemonAleatorio();
		
		pokemonEncontrado.setText("has enconrado un "+pokemon.getName());
		
		

	}
}
