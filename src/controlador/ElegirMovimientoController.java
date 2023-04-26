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
import modelo.Move;
import modelo.Pokemon;
import javafx.scene.control.TableColumn;

public class ElegirMovimientoController implements Initializable {
	@FXML
	private TableView tablaElegirMovimiento;
	@FXML
	private TableColumn nombre;
	@FXML
	private TableColumn potencia;
	@FXML
	private Button seleccionar;

	private static LinkedList<Move> movimientosPokemonEnCombate;

	private static Pokemon pokemonEnCombate = BatallaController.getPokemonElegidoJugador();
//
//	private Move movimiento1 = new Move("PATADA", 10, "ATAQUE", 10, null, null, 0, 0);
//	private Move movimiento2 = new Move("CONGELADO", 10, "ESTADO", 0, null, null, 3, 0);

	public ObservableList<Move> muestraMovimientos() {

		ObservableList<Move> lista = FXCollections.observableArrayList();

		for (int i = 0; i < movimientosPokemonEnCombate.size(); i++) {

			lista.add(movimientosPokemonEnCombate.get(i));

		}
		return lista;
	}

	// Event Listener on Button[#seleccionar].onAction
	@FXML
	public void seleccionar(ActionEvent event) {
		// TODO Autogenerated

		ObservableList<Move> movimientos = tablaElegirMovimiento.getSelectionModel().getSelectedItems();

		BatallaController.setMovimietoJugador(movimientos.get(0));

		// se cierra la ventana actual
		Stage stage2 = (Stage) this.tablaElegirMovimiento.getScene().getWindow();
		stage2.close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		movimientosPokemon.add(movimiento1);
//		movimientosPokemon.add(movimiento2);

		movimientosPokemonEnCombate = pokemonEnCombate.getMoves();

		tablaElegirMovimiento.setItems(muestraMovimientos());

		nombre.setCellValueFactory(new PropertyValueFactory<Move, String>("name"));
		potencia.setCellValueFactory(new PropertyValueFactory<Move, String>("power"));
	}
}
