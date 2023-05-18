package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AprenderMovimientoController implements Initializable{
	@FXML
	private Label lblMov;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		lblMov.setText("HAS APRENDIDO "+ BatallaController.pokemonElegidoJugador.getMoves().getLast().getName());
		
	}
	
	
	

}
