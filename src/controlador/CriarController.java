package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import funcionalidades.ActualizarCaracteristicasPokemon;
import funcionalidades.Criar;
import funcionalidades.Entrenar2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import modelo.Pokemon;
import modelo.Trainer;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class CriarController implements Initializable {

	@FXML
	private Button seleccionar;
	@FXML
	private Button quitar;
	@FXML
	private Button criar;
	@FXML
	private TableView tablaSelecionados;
	@FXML
	private TableColumn moteSeleccionado;
	@FXML
	private TableColumn nombreSelecionado;
	@FXML
	private TableColumn ataqueSelecionado;
	@FXML
	private TableColumn defensaSelecionado;
	@FXML
	private TableColumn ataqueSpSelecionado;
	@FXML
	private TableColumn defensaSpSelecionado;
	@FXML
	private TableColumn velocidadSelecionado;
	@FXML
	private TableColumn estaminaSelecionado;
	@FXML
	private TableColumn nivelSelecionado;
	@FXML
	private TableColumn vitalidadSeleccionado;

	@FXML
	private TableColumn tipo1Selecionado;
	@FXML
	private TableColumn tipo2Selecionado;
	@FXML
	private TableView tablaEquipo;
	@FXML
	private TableColumn mote;
	@FXML
	private TableColumn nombre;
	@FXML
	private TableColumn ataque;
	@FXML
	private TableColumn defensa;
	@FXML
	private TableColumn ataqueSp;
	@FXML
	private TableColumn defensaSp;
	@FXML
	private TableColumn velocidad;
	@FXML
	private TableColumn estamina;
	@FXML
	private TableColumn nivel;
	@FXML
	private TableColumn vitalidad;
	@FXML
	private TableColumn tipo1;
	@FXML
	private TableColumn tipo2;

	private Trainer entrenador=CargarEntrenador.getEntrenador();

	private LinkedList<Pokemon> equipoPokemon = entrenador.getEquipoPokemon();

	// Event Listener on Button[#seleccionar].onAction
	@FXML
	public void seleccionar(ActionEvent event) {
		// TODO Autogenerated

		seleccionarPokemon();
	}

	// Event Listener on Button[#quitar].onAction
	@FXML
	public void quitar(ActionEvent event) {
		// TODO Autogenerated

		ObservableList<Pokemon> pokemonSeleccionado = tablaSelecionados.getSelectionModel().getSelectedItems();

		ObservableList<Pokemon> pokemonPadres = tablaSelecionados.getItems();

		pokemonPadres.remove(pokemonSeleccionado.get(0));

		tablaSelecionados.setItems(pokemonPadres);

	}

	// Event Listener on Button[#criar].onAction
	@FXML
	public void criar(ActionEvent event) {
		// TODO Autogenerated
		ObservableList<Pokemon> pokemonSeleccionado = tablaSelecionados.getItems();
		
		Pokemon pokemon1=pokemonSeleccionado.get(0);
		Pokemon pokemon2=pokemonSeleccionado.get(1);
		
		Criar.Criar(pokemon1, pokemon2, entrenador);
		
		
	}

	public void seleccionarPokemon() {

		ObservableList<Pokemon> pokemonSeleccionado = tablaEquipo.getSelectionModel().getSelectedItems();

		ObservableList<Pokemon> pokemonPadres = tablaSelecionados.getItems();
		
		if(pokemonPadres.size()>1)System.out.println("quita primero uno");
		else {
			pokemonPadres.add(pokemonSeleccionado.get(0));

			

			tablaSelecionados.setItems(pokemonPadres);

			moteSeleccionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
			nombreSelecionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
			ataqueSelecionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
			vitalidadSeleccionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));
		}

		

		


	}

	public ObservableList<Pokemon> metodo() {

		ObservableList<Pokemon> lista = FXCollections.observableArrayList();

		for (int i = 0; i < equipoPokemon.size(); i++) {

			lista.add(equipoPokemon.get(i));

		}

		return lista;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//actualizamos el entrenador por si hemos capturado algun pokemon nuevo
//		entrenador=CargarEntrenador.getEntrenador();

		tablaEquipo.setItems(metodo());

//		tabla.getColumns().addAll(c1);

		mote.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombre.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataque.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		vitalidad.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));

	}
}
