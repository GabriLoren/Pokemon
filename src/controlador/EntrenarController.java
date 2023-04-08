package controlador;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import modelo.Pokemon;
import modelo.Trainer;

import java.util.LinkedList;

import cargar.CargarEntrenador;
import funcionalidades.Entrenar;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class EntrenarController {
	@FXML
	private Button btnEntrenarPokemon;
	@FXML
	private Label lblDescripcion;
	@FXML
	private Label lblEntrenamiento;
	@FXML
	private Label lblPokemonAEntrenar;
	@FXML
	private TextField txtPokemonAEntrenar;
	@FXML
	private TextField txtTipoDeEntrenamiento;
	
	private Pokemon pokemonSeleccionado;
	
	private Trainer entrenador= CargarEntrenador.getEntrenador();
	
	private LinkedList<Pokemon>pokemonsEntrenador=entrenador.getTodosLosPokemon();

	// Event Listener on Button[#btnEntrenarPokemon].onAction
	@FXML
	public void entrenamiento(ActionEvent event) {
		// TODO Autogenerated
		
		String moteDelPokemonEntrenamos=txtPokemonAEntrenar.getText();
		String entrenaminetoElegido=txtTipoDeEntrenamiento.getText();
		
	Entrenar.entrenar(entrenador, "mio2", "pesado");
		
	
		System.out.println(pokemonsEntrenador.get(1).toString());
	
//	System.out.println(pokemonSeleccionado.toString());
	
System.out.println(CargarEntrenador.getEntrenador().getPokeDollar());	
	
	
		
	}
}
