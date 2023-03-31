package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarPokemon;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import modelo.GeneraPokemonAleatorio;
import modelo.Pokemon;
import modelo.Trainer;

public class CapturaController implements Initializable {
	@FXML
	private Button capturarPokemon;
	@FXML
	private Button bucarPokemon;
	@FXML
	private Label pokemonEncontrado;
	@FXML
	private Label pokemonCapturado;

	private Pokemon pokemon;

	private Trainer entrenador=CargarEntrenador.getEntrenador();
	
	private boolean insertado=false;

	// Event Listener on Button[#capturarPokemon].onAction
	@FXML
	public void capturarPokemon(ActionEvent event) {
		
		

		if (pokemon != null && insertado==false) {
			
//Pokemon p=new Pokemon(1, null)
			
			
			CargarEntrenador.getEntrenador().insertarEnBbDdElPokemonEncontrado(pokemon);

			pokemonCapturado.setText("Enhorabuenas has capturado un nuevo " + pokemon.getName());
			
			insertado=true;

		}

		else if (pokemon==null)
			pokemonEncontrado.setText("Aún no has encontrado ningun pokemon");
	}

	// Event Listener on Button[#bucarPokemon].onAction
	@FXML
	public void bucarPokemon(ActionEvent event) {

		pokemon = GeneraPokemonAleatorio.mostrarPokemonEncontrado();

		pokemonEncontrado.setText("has enconrado un " + pokemon.getName());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		CargarPokemon.cargarPokemonDesdeBbDd();

//		for (int i = 0; i < pokemon.size(); i++) {
//            System.out.println(pokemon.get(i).toString());
//		}
//		
	}
}
