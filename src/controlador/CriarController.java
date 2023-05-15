package controlador;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import crud.CargarEntrenador;

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
	private TableView tablaHijo;
	@FXML
	private TableColumn moteHijo;
	@FXML
	private TableColumn nombreHijo;
	@FXML
	private TableColumn ataqueHijo;
	@FXML
	private TableColumn defensaHijo;
	@FXML
	private TableColumn ataqueSpHijo;
	@FXML
	private TableColumn defensaSpHijo;
	@FXML
	private TableColumn velocidadHijo;
	@FXML
	private TableColumn estaminaHijo;
	@FXML
	private TableColumn nivelHijo;
	@FXML
	private TableColumn vitalidadHijo;
	@FXML
	private TableColumn tipo1Hijo;
	@FXML
	private TableColumn tipo2Hijo;
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

	private Trainer entrenador;

	private LinkedList<Pokemon> equipoPokemon;

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

		ObservableList<Pokemon> pokemonEquipo = tablaEquipo.getItems();
		// si no seleccionamos un pokemon antes de pulsar el boton quitar nos salta
		// un error
		try {

			pokemonEquipo.add(pokemonSeleccionado.get(0));

			pokemonPadres.remove(pokemonSeleccionado.get(0));

			tablaSelecionados.setItems(pokemonPadres);

			tablaEquipo.setItems(pokemonEquipo);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("no hay nigun pokemon para quitarlo");
		}

	}

	// Event Listener on Button[#criar].onAction
	@FXML
	public void criar(ActionEvent event) {
		// TODO Autogenerated
		ObservableList<Pokemon> pokemonSeleccionado = tablaSelecionados.getItems();

		// si no seleccionamos un pokemon antes de pulsar el boton criar nos salta
		// un error
//		try {

			Pokemon pokemon1 = pokemonSeleccionado.get(0);
			Pokemon pokemon2 = pokemonSeleccionado.get(1);
			
			System.out.println("p1 "+pokemon1);
			System.out.println("p2 "+pokemon2);
			
			
			//Pokemon resultante de la crianza
			Pokemon pokemonHijo=Criar.Criar(pokemon1, pokemon2, entrenador);

			// mostramos en la tablaHijo el hijo recien creado
			
			ObservableList<Pokemon> pokemonCriado = tablaHijo.getItems();

		

			pokemonCriado.add(pokemonHijo);

			tablaHijo.setItems(pokemonCriado);

			moteHijo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
			nombreHijo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
			ataqueHijo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
			vitalidadHijo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));

//		} catch (Exception e) {
//			System.out.println("Selecciona primero los  2 padres");
//		}

	}

	public void seleccionarPokemon() {

		ObservableList<Pokemon> pokemonSeleccionado = tablaEquipo.getSelectionModel().getSelectedItems();

		ObservableList<Pokemon> pokemonPadres = tablaSelecionados.getItems();

		ObservableList<Pokemon> pokemonEquipo = tablaEquipo.getItems();

		// si está ya los dos padres seleccionados no te permite selecionar otro antes
		// de quitar uno
		if (pokemonPadres.size() > 1)
			System.out.println("quita primero uno");
		else {

			// si ya está un padre seleccionado no te permite volver a seleccionar el mismo
			if (pokemonPadres.size() > 0 && pokemonSeleccionado.get(0) == pokemonPadres.get(0)) {
				System.out.println("ya está seleccionado este padre");
			} else {
				// si no seleccionamos un pokemon antes de pulsar el boton seleccionar nos salta
				// un error
				try {

					pokemonPadres.add(pokemonSeleccionado.get(0));
					pokemonEquipo.remove(pokemonSeleccionado.get(0));
				} catch (Exception e) {
					System.out.println("Selecciona primero los padres");
				}

			}

		}

//		tablaEquipo.setItems(pokemonEquipo);

//		tablaSelecionados.setItems(pokemonPadres);

		moteSeleccionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombreSelecionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataqueSelecionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		vitalidadSeleccionado.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));

	}

	//añadimos a la ObservableList todos los pokemon del equipo del entrenador
	public ObservableList<Pokemon> metodo() {

		ObservableList<Pokemon> lista = FXCollections.observableArrayList();

		for (int i = 0; i < equipoPokemon.size(); i++) {

			lista.add(equipoPokemon.get(i));

		}

		// si utilizamos este procedimieto
//		for (int i = 0; i < equipoPokemon.size(); i++) {
//
//			Pokemon p = new Pokemon(0, null, 0);
//
//			p.setId(equipoPokemon.get(i).getId());
//			p.setName(equipoPokemon.get(i).getName());
//			p.setVit(equipoPokemon.get(i).getVit());
//
//			lista.add(p);
//
//		}

		return lista;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	entrenador = CargarEntrenador.getEntrenador();

	 equipoPokemon = entrenador.getEquipoPokemon();

		// actualizamos el entrenador por si hemos capturado algun pokemon nuevo
//		entrenador=CargarEntrenador.getEntrenador();

		tablaEquipo.setItems(metodo());

//		tabla.getColumns().addAll(c1);

		mote.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombre.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataque.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		vitalidad.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));

	}
}
