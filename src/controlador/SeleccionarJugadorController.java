package controlador;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarMoves;
import cargar.CargarTodosLosEntrenadores;
import cargar.CargarTodosLosObjetos;
import cargar.CargarTodosPokemons;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Corresponde a la primera vista del programa
public class SeleccionarJugadorController implements Initializable {
	@FXML
	private TextField TxtInsertarJugador;
	@FXML
	private Button btbcargarEntrenador;
	@FXML
	private Label lblMostrarUsuario;
	@FXML
	private Button btbCrearUsuario;

	// Event Listener on Button[#btbcargarEntrenador].onMousePressed
	@FXML
	public void mostrarLblEnBlanco(MouseEvent event) {
		// TODO Autogenerated
		lblMostrarUsuario.setText("");
	}

	// Event Listener on Button[#btbcargarEntrenador].onMouseReleased
	@FXML
	public void cargarEntrenador(MouseEvent event) throws IOException, SQLException {
		// TODO Autogenerated
		String entrenador = TxtInsertarJugador.getText().toUpperCase();

	
			if (CargarEntrenador.comprobarUsuarioYCargarlo(entrenador) == false)
				lblMostrarUsuario.setText("El usuario no existe");
			else {

				// abrir la siguiente ventana
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ElegirAccion.fxml"));

				Parent root = loader.load();

				Scene scene = new Scene(root);

				Stage stage = new Stage();

				stage.setScene(scene);
				stage.show();
				// se cierra la ventana actual
				Stage stage2 = (Stage) this.TxtInsertarJugador.getScene().getWindow();
				stage2.close();

			}
			// SI NO HAY NINGUN ENTRENADOR CREADO AÚN SALTA LA EXCEPCION
			// NullPointerException YA QUE LA LINKEDLIST QUE ALBERGA TODOS LOS ENTRENADORES
			// QUE HEMOS CREADO ESTÁ VACIA Y POR LO TANTO SU SIZE ES CERO
		

	}

	// Event Listener on Button[#btbCrearUsuario].onAction
	@FXML
	public void crearUsuario(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/CrearUsuario.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL); // (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		//cargamos todos los movimientos
		CargarMoves.cargarMovimientos();

		// cargamos todos los pokemon existentes en el juego
		CargarTodosPokemons.cargarPokemonDesdeBbDd();

		// cargamos todos los objetos existentes en el juego
		CargarTodosLosObjetos.cargarTododLosObjetos();

		// cargamos todos los entrenadores existentes en el juego
		CargarTodosLosEntrenadores.cargarTodosLosEntrenadores();
	

	}
	
}