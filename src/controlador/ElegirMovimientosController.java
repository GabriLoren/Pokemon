package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarTodosLosEntrenadores;
import funcionalidades.Batalla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;
import javafx.scene.control.TableColumn;

public class ElegirMovimientosController implements Initializable {
	@FXML
	private TableView tablaElegirMovimiento;
	@FXML
	private TableColumn nombre;
	@FXML
	private TableColumn potencia;
	@FXML
	private Button seleccionar;

	private Move movimietoSeleccionado;

	private LinkedList<Move> movimientosPokemonEnCombate;
	public Move getMovimietoSeleccionado() {
		return movimietoSeleccionado;
	}


	public void setMovimientosPokemonEnCombate(LinkedList<Move> movimientosPokemonEnCombate) {
		this.movimientosPokemonEnCombate = movimientosPokemonEnCombate;
	}

	public ObservableList<Move> mostrar() {
		
		System.out.println("tamanino "+movimientosPokemonEnCombate.size());

		ObservableList<Move> listaObservableList = FXCollections.observableArrayList();

		for (int i = 0; i < movimientosPokemonEnCombate.size(); i++) {

			listaObservableList.add(movimientosPokemonEnCombate.get(i));

		}
		return listaObservableList;
	}



	// Event Listener on Button[#seleccionar].onAction
	@FXML
	public void seleccionar(ActionEvent event) throws IOException {
		// TODO Autogenerated

		ObservableList<Move> movimientos = tablaElegirMovimiento.getSelectionModel().getSelectedItems();

		movimietoSeleccionado= movimientos.get(0);

		// se cierra la ventana actual
		Stage stage2 = (Stage) this.seleccionar.getScene().getWindow();
		stage2.close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		movimientosPokemonEnCombate=BatallaController.pokemonElegidoJugador.getMoves();
		
		System.out.println("tamanio "+movimientosPokemonEnCombate.size());

		tablaElegirMovimiento.setItems(mostrar());

		nombre.setCellValueFactory(new PropertyValueFactory<Move, String>("name"));
		potencia.setCellValueFactory(new PropertyValueFactory<Move, String>("power"));

	}
}
