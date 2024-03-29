package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Pokemon;
import javafx.scene.control.TableColumn;

public class ElegirPokemonBatallaController implements Initializable{
	@FXML
	private Button seleccionar;
	@FXML
	private TableView tabla;
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
	
	static LinkedList<Pokemon> equipoJugador;
	
	static Pokemon pokemonElegido;


	public ObservableList<Pokemon> muestraEquipo() {

		ObservableList<Pokemon> lista = FXCollections.observableArrayList();

		for (int i = 0; i < equipoJugador.size(); i++) {

			lista.add(equipoJugador.get(i));

		}
		return lista;
	}

	// Event Listener on Button[#seleccionar].onAction
	@FXML
	public void seleccionar(ActionEvent event){
		// TODO Autogenerated
		
		ObservableList<Pokemon> pokemonSeleccionado = tabla.getSelectionModel().getSelectedItems();

		pokemonElegido=pokemonSeleccionado.get(0);

		
		// se cierra la ventana actual
				Stage stage = (Stage) this.tabla.getScene().getWindow();
				stage.close();
				
				

		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		equipoJugador=BatallaController.equipoJugador;
		
		tabla.setItems(muestraEquipo());

		mote.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombre.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataque.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		vitalidad.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));
		
	}
}
