package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import crud.CargarEntrenador;
import javafx.event.ActionEvent;

public class ElegirAccionController {
	@FXML
	private Button btnCapturar;
	@FXML
	private Button btnPelear;
	@FXML
	private Button btnTienda;
	@FXML
	private Button btnCriar;
	@FXML
	private Button BtnEquipo;
	@FXML
	private Button btnEntrenar;
	
	@FXML
	public void cambiarUsuario(ActionEvent event) throws IOException {
		// TODO Autogenerated
		
		CargarEntrenador.setEntrenador(null);

		// abre la ventana Captura
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SeleccionarJugador.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
		
		
		// se cierra la ventana actual
		Stage stage2 = (Stage) this.btnCriar.getScene().getWindow();
		stage2.close();
	}

	// Event Listener on Button[#btnEntrenar].onAction
	@FXML
	public void entrenar(ActionEvent event) throws IOException {
		// TODO Autogenerated

		// abre la ventana Captura
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Entrenar2.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
	}

	// Event Listener on Button[#btnCapturar].onAction
	@FXML
	public void capturar(ActionEvent event) throws IOException {
		// TODO Autogenerated
		// abre la ventana Captura
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Captura.fxml"));//aquí va la vista Captura

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
	}

	// Event Listener on Button[#btnPelear].onAction
	@FXML
	public void pelear(ActionEvent event) throws IOException {
		// TODO Autogenerated

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Batalla.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();

	}

	// Event Listener on Button[#btnTienda].onAction
	@FXML
	public void tienda(ActionEvent event) throws IOException {
		// TODO Autogenerated
		// abrir la ventana Tienda
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Tienda.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL); //(hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();

//		TiendaController.getLblMisObjetos().setText("a");

	}

	// Event Listener on Button[#btnCriar].onAction
	@FXML
	public void criar(ActionEvent event) throws IOException {
		// TODO Autogenerated

		// abre la ventana Captura
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Criar.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
	}

	// Event Listener on Button[#BtnEquipo].onAction
	@FXML
	public void hacerEquipo(ActionEvent event) throws IOException {
		// TODO Autogenerated

		// abrir la ventana InsertarEquipo
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InsertarEnEquipo2.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); //(hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();
	}
}
