package controlador;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import crud.CargarEntrenador;
import crud.CargarTodosPokemons;
import funcionalidades.ActualizarCaracteristicasPokemon;
import funcionalidades.Entrenar2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Pokemon;
import modelo.Trainer;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class Entrenar2Controller implements Initializable {

	@FXML
	private Label pokedollarEntrenador;
	@FXML
	private Label precioEntrenamiento;
	@FXML
	private TableView tabla;
	@FXML
	private TableColumn moteEquipo;
	@FXML
	private TableColumn nombreEquipo;
	@FXML
	private TableColumn ataqueEquipo;
	@FXML
	private TableColumn defensaEquipo;
	@FXML
	private TableColumn ataqueSpEquipo;
	@FXML
	private TableColumn defensaSpEquipo;
	@FXML
	private TableColumn velocidadEquipo;
	@FXML
	private TableColumn estaminaEquipo;
	@FXML
	private TableColumn nivelEquipo;
	@FXML
	private TableColumn vitalidadEquipo;

	private Trainer entrenador = CargarEntrenador.getEntrenador();

	private ObservableList<Pokemon> pokemonSeleccionado;

//	private LinkedList<Pokemon> equipoPokemon = entrenador.getEquipoPokemon();

	public void seleccionarPokemon(String tipoEntrenamiento) {

		pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

		int idPokemonSeleccionado = pokemonSeleccionado.get(0).getId();

		for (int i = 0; i < entrenador.getEquipoPokemon().size(); i++) {

			if (entrenador.getEquipoPokemon().get(i).getId() == idPokemonSeleccionado) {

				// si es true muestra en el label "no hay suficiente dinero"
				if (Entrenar2.tipoEntrenamiento(entrenador, tipoEntrenamiento, entrenador.getEquipoPokemon().get(i)))
					pokedollarEntrenador.setText("NO HAY SUFICIENTE DINERO");

//				else {
//
//					ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(entrenador.getEquipoPokemon().get(i));
//
//				}
				tabla.setItems(metodo());

			}

		}
	}

	public ObservableList<Pokemon> metodo() {

		ObservableList<Pokemon> lista = FXCollections.observableArrayList();

		LinkedList<Pokemon> equipo = entrenador.getEquipoPokemon();

		for (int i = 0; i < equipo.size(); i++) {

			Pokemon P = new Pokemon(equipo.get(i));

			lista.add(P);

		}

		return lista;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

//		System.out.println(todosLosPokemon.toString());

		pokedollarEntrenador.setText("SALDO\n" + CargarEntrenador.getEntrenador().getPokeDollar() + " POKEDOLLAR");

		tabla.setItems(metodo());

//		tabla.getColumns().addAll(c1);

		moteEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombreEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataqueEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		defensaEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("def"));
		ataqueSpEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("spAtk"));
		defensaSpEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("spDef"));
		vitalidadEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));
		velocidadEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("speed"));
		estaminaEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("stamina"));
		nivelEquipo.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("level"));

//		System.out.println(equipoPokemon);

	}

//	// Event Listener on Button.onAction
//		@FXML
//		public void eliminar(ActionEvent event) {
//			
//			seleccionarPokemon();
//			
//		}

	// Event Listener on Button.onMouseExited
	@FXML
	public void funcionalExited(MouseEvent event) {
		// TODO Autogenerated
		precioEntrenamiento.setText("");
	}

	// Event Listener on Button.onMouseEntered
	@FXML
	public void precioFuncional(MouseEvent event) {
		// TODO Autogenerated

		try {
			pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

			precioEntrenamiento.setText("VELOCIDAD +5          PRECIO " + pokemonSeleccionado.get(0).getLevel() * 40
					+ "\nATAQUE +5" + "\nDEFENSA +5" + "\nVIDA +5");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	// Event Listener on Button.onMouseExited
	@FXML
	public void furiosoExited(MouseEvent event) {
		// TODO Autogenerated
		precioEntrenamiento.setText("");
	}

	// Event Listener on Button.onMouseEntered
	@FXML
	public void precioFurioso(MouseEvent event) {
		// TODO Autogenerated

		try {
			pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

			precioEntrenamiento.setText("VELOCIDAD +5          PRECIO " + pokemonSeleccionado.get(0).getLevel() * 30
					+ "\nATAQUE +5" + "\nATAQUESP +5");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	// Event Listener on Button.onMouseExited
		@FXML
		public void oniricoExited(MouseEvent event) {
			// TODO Autogenerated
			precioEntrenamiento.setText("");
		}

		// Event Listener on Button.onMouseEntered
		@FXML
		public void precioOnirico(MouseEvent event) {
			// TODO Autogenerated

			try {
				pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

				precioEntrenamiento.setText("VELOCIDAD +5          PRECIO " + pokemonSeleccionado.get(0).getLevel() * 40
						+ "\nVITALIDAD +5" + "\nATAQUESP +5" + "\nDEFENSASP +5");
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		// Event Listener on Button.onMouseExited
				@FXML
				public void pesadoExited(MouseEvent event) {
					// TODO Autogenerated
					precioEntrenamiento.setText("");
				}

				// Event Listener on Button.onMouseEntered
				@FXML
				public void precioPesado(MouseEvent event) {
					// TODO Autogenerated

					try {
						pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

						precioEntrenamiento.setText("VITALIDAD +5           PRECIO " + pokemonSeleccionado.get(0).getLevel() * 20
								 + "\nDEFENSA +5" + "\nDEFENSASP +5");
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

	// Event Listener on Button.onAction
	@FXML
	public void furioso(ActionEvent event) {
		// TODO Autogenerated

		try {
			seleccionarPokemon("FURIOSO");
			pokedollarEntrenador.setText("SALDO\n" + CargarEntrenador.getEntrenador().getPokeDollar() + " POKEDOLLAR");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			precioEntrenamiento.setText("SELECCIONA UN POKEMON");
		}

	}

	// Event Listener on Button.onAction
	@FXML
	public void funcional(ActionEvent event) {
		// TODO Autogenerated
	try {
		seleccionarPokemon("FUNCIONAL");
		pokedollarEntrenador.setText("SALDO\n" + CargarEntrenador.getEntrenador().getPokeDollar() + " POKEDOLLAR");
		} catch (Exception e) {
			// TODO: handle exception
			precioEntrenamiento.setText("SELECCIONA UN POKEMON");
		}
		
	}

	// Event Listener on Button.onAction
	@FXML
	public void onirico(ActionEvent event) {
		// TODO Autogenerated
	try {
		seleccionarPokemon("ONIRICO");
		pokedollarEntrenador.setText("SALDO\n" + CargarEntrenador.getEntrenador().getPokeDollar() + " POKEDOLLAR");
			
		} catch (Exception e) {
			// TODO: handle exception
			precioEntrenamiento.setText("SELECCIONA UN POKEMON");
		}
		
	}

	// Event Listener on Button.onAction
	@FXML
	public void pesado(ActionEvent event) {
		// TODO Autogenerated
		try {
			seleccionarPokemon("PESADO");
			pokedollarEntrenador.setText("SALDO\n" + CargarEntrenador.getEntrenador().getPokeDollar() + " POKEDOLLAR");
			
		} catch (Exception e) {
			// TODO: handle exception
			precioEntrenamiento.setText("SELECCIONA UN POKEMON");
		}
		

	}

}
