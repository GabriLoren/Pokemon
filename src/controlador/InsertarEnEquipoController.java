package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import modelo.Pokemon;
import modelo.Trainer;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarPokemonEnEntrenador;
import cargar.CargarTodosLosObjetos;
import cargar.CargarTodosPokemons;
import funcionalidades.InsertarEnEquipo;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class InsertarEnEquipoController implements Initializable {
	@FXML
	private TextField txtInsertar;
	@FXML
	private TextField txtSacar;
	@FXML
	private Button btnInsertar;
	@FXML
	private Label lblInsertar;
	@FXML
	private Label lblSacar;
	@FXML
	private Label lblEquipo;
	@FXML
	private Label lblTodos;

	private Trainer entrenador = CargarEntrenador.getEntrenador();

	private String equipo;

	String todosPokemon;

	// Event Listener on Button[#btnInsertar].onAction
	@FXML
	public void insertar(ActionEvent event) {
		// TODO Autogenerated

		String mote = txtInsertar.getText();

		int pokemonInsertado = InsertarEnEquipo.insertarEnEquipo(entrenador, mote);

		switch (pokemonInsertado) {

		case 0: {

			lblEquipo.setText("no hay pokemon para añadir\n" + equipo);
			break;

		}

		case -1: {

			lblEquipo.setText("El pokemon no existe\n" + equipo);
			break;
		}
		case 2: {

			lblEquipo.setText("El está completo, saca uno primero\n" + equipo);
			break;
		}
		case 3: {
			lblEquipo.setText("Añadido correctamente\n" + equipo);
			break;
		}

		}

		todosPokemon = entrenador.mostraTodosLosPokemons();

		String NombresEquipo = "";
		for (int i = 0; i < entrenador.getEquipoPokemon().size(); i++) {

			NombresEquipo += entrenador.getEquipoPokemon().get(i).getName()+"\n";

		}

		System.out.println(todosPokemon);

		lblTodos.setText(todosPokemon);

		lblEquipo.setText(NombresEquipo);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		todosPokemon = entrenador.mostraTodosLosPokemons();

		equipo = entrenador.getEquipoPokemon().toString();

		System.out.println(todosPokemon);

		lblTodos.setText(todosPokemon);

		lblEquipo.setText(equipo);

	}
}
